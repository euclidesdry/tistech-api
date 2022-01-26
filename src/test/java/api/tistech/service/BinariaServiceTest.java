package api.tistech.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import api.tistech.model.ArvoreBinaria;

@RunWith(SpringRunner.class)
public class BinariaServiceTest {
	
	@Autowired
    ArvoreBinariaService arvoreBinariaServicee;
	
	@Autowired
	ArvoreBinaria arvoreBinaria;
	
	@TestConfiguration
	static class ArvoreBinariaTestConfiguration {
		
		@Bean
		public ArvoreBinariaService ArvoreBinariaService() {
			return new ArvoreBinariaService();
		}
	}

	@Test
	public void ArvoreBinariaTestSomarNos() {
		
		int valor = 5;
		
		int soma = arvoreBinariaServicee.somarAdjacente(arvoreBinaria, valor);
		
		Assertions.assertEquals(soma, 6);
	}
	
	@Before
	public ArvoreBinaria setup() {
		
		ArvoreBinaria noLadoEsquerdo = new ArvoreBinaria();
        noLadoEsquerdo.setValor(2);
        
        ArvoreBinaria noLadoDireito = new ArvoreBinaria();
        noLadoDireito.setValor(4);

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.setValor(9);
   
        arvoreBinaria.setEsquerda(noLadoEsquerdo);
        arvoreBinaria.setDireita(noLadoDireito);
		
		return arvoreBinaria;
	}
}
