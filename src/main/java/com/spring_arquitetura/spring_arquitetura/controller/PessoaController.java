package com.spring_arquitetura.spring_arquitetura.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_arquitetura.spring_arquitetura.core.AbstractController;
import com.spring_arquitetura.spring_arquitetura.entity.Pessoa;
import com.spring_arquitetura.spring_arquitetura.exceptions.ErrorExcep;


@RestController
@RequestMapping("/pessoa")
public class PessoaController extends AbstractController<Pessoa> {

    @Override
    @PostMapping
    public ResponseEntity<?> save(@RequestBody() Pessoa pessoa) {

       
        if (pessoa.getNome() == null) {
        throw new ErrorExcep("O nome não pode ficar vazio");
        }else if(pessoa.getIdade() < 18){
            throw new ErrorExcep("O cadastro não é permitido para menores de 18 anos");
        }
        return new ResponseEntity<>(service.save(pessoa), HttpStatus.OK);

       

    }
}