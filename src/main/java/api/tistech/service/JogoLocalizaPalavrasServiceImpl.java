package api.tistech.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JogoLocalizaPalavrasServiceImpl implements IJogoLocalizaPalavrasService {

    private char[][] matrizPalavras = {
            { 'A', 'B', 'L', 'N', 'H', 'E', 'H', 'L', 'L', 'T', 'B', 'Q', 'J', 'F', 'R', 'G', 'Q', 'H' },
            { 'K', 'J', 'U', 'T', 'W', 'R', 'A', 'Z', 'I', 'L', 'A', 'C', 'O', 'L', 'V', 'M', 'N', 'J' },
            { 'F', 'E', 'O', 'G', 'E', 'Q', 'H', 'T', 'L', 'O', 'I', 'D', 'F', 'M', 'B', 'A', 'O', 'Q' },
            { 'R', 'W', 'B', 'N', 'U', 'S', 'G', 'E', 'V', 'I', 'X', 'O', 'I', 'O', 'X', 'G', 'U', 'Z' },
            { 'B', 'R', 'D', 'A', 'R', 'G', 'T', 'E', 'N', 'T', 'A', 'T', 'I', 'V', 'A', 'Y', 'J', 'K' },
            { 'E', 'A', 'R', 'H', 'S', 'O', 'W', 'E', 'S', 'L', 'F', 'V', 'C', 'D', 'P', 'Z', 'J', 'Q' },
            { 'W', 'E', 'C', 'S', 'W', 'A', 'T', 'L', 'X', 'B', 'M', 'T', 'R', 'C', 'D', 'P', 'L', 'I' },
            { 'R', 'E', 'C', 'S', 'Q', 'A', 'T', 'R', 'W', 'B', 'M', 'V', 'R', 'C', 'K', 'P', 'L', 'I' },
            { 'W', 'E', 'C', 'S', 'W', 'A', 'R', 'L', 'W', 'B', 'M', 'R', 'L', 'C', 'K', 'P', 'L', 'I' },
            { 'B', 'O', 'C', 'Q', 'W', 'A', 'R', 'L', 'W', 'B', 'J', 'K', 'L', 'A', 'K', 'P', 'L', 'A' },
            { 'W', 'E', 'H', 'S', 'K', 'U', 'R', 'L', 'W', 'B', 'M', 'R', 'L', 'C', 'K', 'P', 'L', 'I' },
            { 'E', 'Q', 'C', 'S', 'W', 'A', 'X', 'U', 'X', 'B', 'M', 'G', 'O', 'C', 'K', 'P', 'L', 'Q' },
            { 'W', 'E', 'G', 'L', 'W', 'A', 'R', 'L', 'X', 'B', 'M', 'R', 'L', 'C', 'K', 'P', 'N', 'I' },
            { 'W', 'E', 'C', 'S', 'C', 'A', 'R', 'L', 'X', 'B', 'C', 'R', 'L', 'R', 'O', 'P', 'I', 'W' },
            { 'W', 'F', 'O', 'H', 'W', 'X', 'R', 'L', 'U', 'B', 'M', 'R', 'L', 'C', 'K', 'P', 'N', 'I' },
            { 'P', 'E', 'C', 'S', 'W', 'A', 'U', 'L', 'X', 'B', 'M', 'R', 'L', 'C', 'D', 'E', 'N', 'K' },
            { 'W', 'R', 'C', 'S', 'L', 'A', 'T', 'L', 'X', 'B', 'U', 'T', 'E', 'X', 'D', 'P', 'N', 'I' },
            { 'Q', 'E', 'C', 'S', 'W', 'A', 'T', 'L', 'X', 'B', 'M', 'T', 'L', 'C', 'O', 'P', 'N', 'J' },
    };

    private void mostrarMatriz() {

        for (int i = 0; i < matrizPalavras.length; i++) {
            for (int j = 0; j < matrizPalavras[i].length; j++) {
                System.out.print(" " + matrizPalavras[i][j] + " ");
            }
            System.out.print("\r\n");
        }
    }

    @Override
    public boolean localiza(String palavra) {

        for (int[] pos : resolucaoPalavra(palavra)) {

            String novaPalavra = palavraMatriz(pos, palavra.length(), 0, 1);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), 0, -1);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, 0);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, 0);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, 1);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, -1);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, 1);
            if (novaPalavra.equals(palavra))
                return true;

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, -1);
            if (novaPalavra.equals(palavra))
                return true;
        }
        return false;
    }

    private int[][] resolucaoPalavra(String palavraResolver) {
        char primeiraLetra = palavraResolver.charAt(0);
        List<int[]> indiceInvertido = new ArrayList<int[]>();

        for (int i = 0; i < matrizPalavras.length; i++) {
            for (int j = 0; j < matrizPalavras[i].length; j++) {
                if (matrizPalavras[i][j] == primeiraLetra) {
                    indiceInvertido.add(new int[] { i, j });
                }
            }
        }
        return toArrayInt(indiceInvertido);
    }

    private int[][] toArrayInt(List<int[]> lista) {
        return (int[][]) lista.toArray(new int[lista.size()][lista.get(0).length]);
    }

    private String palavraMatriz(int[] posInicial, int numeroDeCaracteres, int moverFila, int moverColuna) {
        String palavra = "";
        int recorrido = 0, fila = posInicial[0], coluna = posInicial[1];

        while ((recorrido < numeroDeCaracteres) &&
                (fila < matrizPalavras.length && coluna < matrizPalavras.length) &&
                (fila > -1 && coluna > -1)) {

            palavra += matrizPalavras[fila][coluna];
            fila = fila + moverFila;
            coluna = coluna + moverColuna;
            recorrido++;
        }

        return palavra;
    }
}
