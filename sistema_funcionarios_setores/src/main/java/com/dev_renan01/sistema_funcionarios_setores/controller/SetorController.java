package com.dev_renan01.sistema_funcionarios_setores.controller;

import com.dev_renan01.sistema_funcionarios_setores.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;



}
