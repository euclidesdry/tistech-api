package api.tistech.controllers;

import api.tistech.security.JWTLoginFilter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api
@RequestMapping("")
public class UserController {

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de pessoa"),
			@ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
			@ApiResponse(code = 500, message = "Foi gerada uma exceção"),
	})
	@RequestMapping(value = "/pessoa", method = RequestMethod.GET, produces="application/json")
	public String user() {
		return "{\"users\":[{\"name\":\"João\", \"country\":\"Brazil\"}," +
				"{\"name\":\"Yon\",\"country\":\"China\"},"+
				"{\"name\":\"Eleonora\",\"country\":\"Angola\"}]}";
	}
}
