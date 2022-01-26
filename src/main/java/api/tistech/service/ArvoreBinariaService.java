package api.tistech.service;

import org.springframework.stereotype.Service;

import api.tistech.model.ArvoreBinaria;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ArvoreBinariaService {

	public static ArvoreBinaria buscar(ArvoreBinaria arvoreBinaria, int valor) {
		return ArvoreBinaria.percorrer(arvoreBinaria, valor);
	}

	public int somarAdjacente(ArvoreBinaria arvoreBinaria, int valor) {

		log.info("Percorrendo Nós da árvore ...");
		ArvoreBinaria arvore = ArvoreBinaria.percorrer(arvoreBinaria, valor);

		if (arvore == null) {
			log.warn("Valor não encontrado!");
			return 0;
		}

		int soma = ArvoreBinaria.somar(arvore.getDireita()) + ArvoreBinaria.somar(arvore.getEsquerda());
		log.info("Soma dos Nós adjacentes = " + soma );
		return soma;
	}
}
