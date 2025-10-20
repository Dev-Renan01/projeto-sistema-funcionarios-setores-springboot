package com.dev_renan01.sistema_funcionarios_setores.controller;

import com.dev_renan01.sistema_funcionarios_setores.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/setor")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
}
