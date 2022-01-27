package api.tistech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import api.tistech.service.NumerosService;
import api.tistech.service.JogoLocalizaPalavrasServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class TistechApiApplicationTests {

	@Autowired
	JogoLocalizaPalavrasServiceImpl jogoLocalizaPalavrasService;

	@Autowired
	NumerosService numerosService;

	@Test
	void contextLoads() {
	}

	@Test
	void jogoLocalizaPalavras() throws Exception {
		String palavraTest = "BAIXA";

		Boolean palavra = jogoLocalizaPalavrasService.localiza(palavraTest);
		Assertions.assertEquals(true, palavra);
	}

	@Test
	void menorQueUmMilhao() throws Exception {
		String a = "102";
		String b = "512";

		String c = numerosService.uniao(a, b);
		Assertions.assertEquals("150122", c);
	}

	@Test
	void menorQueUmMilhaoAMenorQueB() throws Exception {
		String a = "10";
		String b = "5128";

		String c = numerosService.uniao(a, b);
		Assertions.assertEquals("150122", c);
	}

	@Test
	void numeroMaiorQueUmMilhao() throws Exception {
		String a = "10256";
		String b = "512";

		String c = numerosService.uniao(a, b);
		Assertions.assertEquals("-1", c);
	}
}
