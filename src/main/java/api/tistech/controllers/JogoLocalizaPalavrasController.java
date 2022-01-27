package api.tistech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.tistech.service.JogoLocalizaPalavrasServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("")
@Slf4j
public class JogoLocalizaPalavrasController {

    @Autowired
    JogoLocalizaPalavrasServiceImpl jogoLocalizaPalavras;

    @GetMapping("/")
    public boolean localizaPalavra(@RequestParam String palavra) {
        log.info("Iniciando jogo localiza palavra!");
        Boolean palavraLocalizada = jogoLocalizaPalavras.localiza(palavra.toUpperCase());
        log.info("Palavra localizada: ", (palavraLocalizada ? "Sim" : "Não"));
        return palavraLocalizada;
    }
}
