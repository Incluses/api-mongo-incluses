package com.example.demo.controller;

import com.example.demo.models.Funcao;
import com.example.demo.service.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcoes")
public class FuncaoController {
    @Autowired
    private FuncaoService funcaoService;

    // Criar uma nova função
    @PostMapping
    public ResponseEntity<Funcao> criarFuncao(@RequestBody Funcao funcao) {
        Funcao novaFuncao = funcaoService.criarFuncao(funcao);
        return ResponseEntity.status(201).body(novaFuncao);
    }

    // Listar todas as funções
    @GetMapping
    public List<Funcao> listarFuncoes() {
        return funcaoService.listarFuncoes();
    }

    // Obter uma função por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcao> obterFuncao(@PathVariable String id) {
        return funcaoService.obterFuncao(id)
                .map(funcao -> ResponseEntity.ok(funcao))
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma função
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncao(@PathVariable String id) {
        if (funcaoService.deletarFuncao(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
