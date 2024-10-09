package com.example.demo.controller;

import com.example.demo.models.Postagem;
import com.example.demo.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    // Criar uma nova postagem
    @PostMapping("/inserir")
    public ResponseEntity<Postagem> criarPostagem(@RequestBody Postagem postagem) {
        Postagem novaPostagem = postagemService.criarPostagem(postagem);
        return ResponseEntity.status(201).body(novaPostagem);
    }

    // Listar todas as postagens
    @GetMapping("/listar")
    public List<Postagem> listarPostagens() {
        return postagemService.listarPostagens();
    }

    // Obter uma postagem por ID
    @GetMapping("/{id}")
    public ResponseEntity<Postagem> obterPostagem(@PathVariable String id) {
        return postagemService.obterPostagem(id)
                .map(postagem -> ResponseEntity.ok(postagem))
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma postagem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable String id) {
        if (postagemService.deletarPostagem(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
