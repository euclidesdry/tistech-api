package api.tistech;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import api.tistech.model.ArvoreBinaria;
import api.tistech.service.ArvoreBinariaService;
import api.tistech.service.NumerosService;

@SpringBootTest
@AutoConfigureMockMvc
class TistechApiApplicationTests {

    @Autowired
    ArvoreBinariaService arvoreBinariaService;
    
    @Autowired
    NumerosService numerosService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void somarNos() throws Exception {

		ArvoreBinaria noLadoEsquerdo = new ArvoreBinaria();
        noLadoEsquerdo.setValor(2);
        
        ArvoreBinaria noLadoDireito = new ArvoreBinaria();
        noLadoDireito.setValor(4);

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.setValor(9);
   
        arvoreBinaria.setEsquerda(noLadoEsquerdo);
        arvoreBinaria.setDireita(noLadoDireito);

		int binaryReturn = arvoreBinariaService.somarAdjacente(arvoreBinaria, 9);

		Assertions.assertEquals(6, binaryReturn);
	}
	
	@Test
	void errorSomarNos() throws Exception {

		ArvoreBinaria noLadoEsquerdo = new ArvoreBinaria();
        noLadoEsquerdo.setValor(2);
        
        ArvoreBinaria noLadoDireito = new ArvoreBinaria();
        noLadoDireito.setValor(4);

        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.setValor(9);
        
   
        arvoreBinaria.setEsquerda(noLadoEsquerdo);
        arvoreBinaria.setDireita(noLadoDireito);
		

		int soma = arvoreBinariaService.somarAdjacente(arvoreBinaria, 9);
		
		Assertions.assertFalse(soma!=6);
	}
	
	@Test
	void terceiroNumero() throws Exception {
		String a = "102";
		String b = "512";
		
		String c = numerosService.uniao(a, b);

		Assertions.assertEquals("150122", c);
	}
	
	@Test
	void terceiroNumeroRetornaMenosUm() throws Exception {
		String a = "10256";
		String b = "512";
		
		String c = numerosService.uniao(a, b);

		Assertions.assertEquals("-1", c);
	}
}
