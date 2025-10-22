package com.dev_renan01.sistema_funcionarios_setores.controller;

import com.dev_renan01.sistema_funcionarios_setores.model.Setor;
import com.dev_renan01.sistema_funcionarios_setores.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/setor")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;


    @GetMapping(value = "/listar")
    @ResponseBody
    public ResponseEntity<List<Setor>> listarTodos(){
       List<Setor> setor = setorRepository.findAll();

        return new ResponseEntity<List<Setor>>(setor, HttpStatus.OK);
    }

    @PostMapping(value = "/salvar")
    @ResponseBody
    public ResponseEntity<Setor> salvarSetor(@RequestBody Setor setor){
        Setor salvarSetor = setorRepository.save(setor);

        return new ResponseEntity<>(salvarSetor, HttpStatus.CREATED);
    }

    @PutMapping(value = "/atualizar")
    @ResponseBody
    public ResponseEntity<?> atualizarSetor(@RequestBody Setor setor){

        if(setor.getId() != null){
            Setor atualizarSetor = setorRepository.saveAndFlush(setor);

            return new ResponseEntity<Setor>(atualizarSetor, HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id não encontrado!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/deletar")
    @ResponseBody
    public ResponseEntity<String> deletarPorId(@RequestParam Long id){
        if(id != null){
            setorRepository.deleteById(id);

            return new ResponseEntity<String>("Deletado com sucesso.", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Id não encontrado!", HttpStatus.NOT_FOUND);
        }
    }
}
