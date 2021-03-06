package api.tistech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.tistech.service.NumerosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Api
@RequestMapping("")
@Slf4j
public class NumerosController {
	
	@Autowired
	NumerosService numerosService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna uma terceira string C"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@GetMapping(value = "/retornar-valor-c", produces = "application/json")
	// @RequestBody ArvoreBinaria arvore,
	public String terceiroC(@RequestParam("a") String a, @RequestParam("b") String b) {
		log.info("Iniciando funcionalidade C!");
		String c = numerosService.uniao(a, b);
		log.info("Retornando o valor de C = " + c);
		return c;
	}
}
