package com.dev_renan01.sistema_funcionarios_setores.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

@RestController
public class HelloController {

    @GetMapping(value = "/hello/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public String olaController(@PathVariable(value = "nome") String nome){
        return "Olá, " + nome + " seja bem vindo(a) ao meu projeto!";
    }
}