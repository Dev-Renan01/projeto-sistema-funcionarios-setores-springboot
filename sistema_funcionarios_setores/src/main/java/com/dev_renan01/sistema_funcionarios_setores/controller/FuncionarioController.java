package com.dev_renan01.sistema_funcionarios_setores.controller;

import com.dev_renan01.sistema_funcionarios_setores.model.Funcionario;
import com.dev_renan01.sistema_funcionarios_setores.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/listar")
    @ResponseBody
    public ResponseEntity<List<Funcionario>> listarFuncionarios(){
       List<Funcionario> funcionario = funcionarioRepository.findAll();

        return new ResponseEntity<List<Funcionario>>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/salvar")
    @ResponseBody
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario){
        Funcionario funcionarioSalvar = funcionarioRepository.save(funcionario);

         return new ResponseEntity<Funcionario>(funcionarioSalvar, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizarFuncionario(@RequestBody Funcionario funcionario){
        if(funcionario.getId() == null){
            return new ResponseEntity<String>("ID não encontrado!", HttpStatus.NOT_FOUND);

        }else{
          Funcionario funcionarioAtualizar = funcionarioRepository.saveAndFlush(funcionario);
            return new ResponseEntity<Funcionario>(funcionarioAtualizar, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deletar")
    @ResponseBody
    public ResponseEntity<String> deletarFuncionarioPorId(@RequestParam Long id) {

        if (id == null) {
            return new ResponseEntity<String>("ID inválido.", HttpStatus.NOT_FOUND);

        } else if (!funcionarioRepository.existsById(id)) {
            return new ResponseEntity<String>("Funcionário não encontrado", HttpStatus.NOT_FOUND);

        } else{
            funcionarioRepository.deleteById(id);
            return new ResponseEntity<String>("Deletado com sucesso!", HttpStatus.OK);
        }
    }
}