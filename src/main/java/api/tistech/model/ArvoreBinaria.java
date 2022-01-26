package api.tistech.model;

import lombok.Data;

@Data
public class ArvoreBinaria {

	private int valor;
	private ArvoreBinaria esquerda;
	private ArvoreBinaria direita;

	public static int somar(ArvoreBinaria arvoreBinaria) {
		if (arvoreBinaria == null) {
			return 0;
		}

		return arvoreBinaria.getValor()
				+ (arvoreBinaria.getDireita() == null ? 0 : somar(arvoreBinaria.getDireita()))
				+ (arvoreBinaria.getEsquerda() == null ? 0 : somar(arvoreBinaria.getEsquerda()));
	}

	public static ArvoreBinaria percorrer(ArvoreBinaria arvoreBinaria, int valor) {

		if (arvoreBinaria.getValor() == valor) {
			return arvoreBinaria;
		}

		if (arvoreBinaria.getEsquerda() != null) {
			ArvoreBinaria ret = percorrer(arvoreBinaria.getEsquerda(), valor);
			if (ret != null) {
				return ret;
			}
		}

		if (arvoreBinaria.getEsquerda() != null) {
			return percorrer(arvoreBinaria.getDireita(), valor);
		}
		return null;
	}
}
