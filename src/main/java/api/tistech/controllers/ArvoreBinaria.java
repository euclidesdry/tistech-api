package api.tistech.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.tistech.service.ArvoreBinariaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;


@RestController
@Api
@RequestMapping("")
@Slf4j
public class ArvoreBinaria {

	@Autowired
	ArvoreBinariaService arvoreBinariaService;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorno da soma dos nós"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar essa funcionalidade!"),
			@ApiResponse(code = 500, message = "Upppsss! Ocorreu um erro"),
	})
	@GetMapping(value = "/somarNos/{valor}", produces="application/json")
	public int somarNos(@RequestBody api.tistech.model.ArvoreBinaria arvore, @PathVariable("valor") int valor) {
		log.info("Serviço de soma acessado com sucesso!");
		return arvoreBinariaService.somarAdjacente(arvore, valor);
	}
}
