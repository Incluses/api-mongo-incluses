package com.example.demo.controller;

import com.example.demo.models.Postagem;
import com.example.demo.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<Postagem> obterPostagem(@PathVariable UUID id) {
        return postagemService.obterPostagem(id)
                .map(postagem -> ResponseEntity.ok(postagem))
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma postagem
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPostagem(@PathVariable UUID id) {
        if (postagemService.deletarPostagem(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/like")
    public ResponseEntity<String> addLike(@RequestParam("id_user") UUID idUser, @RequestParam("id_postagem") UUID idPostagem) {
        return postagemService.addLike(idUser, idPostagem);
    }

    @PostMapping("/comentar")
    public ResponseEntity<String> addComentario(@RequestParam("id_user") UUID idUser, @RequestParam("id_postagem") UUID idPostagem, @RequestParam("comentario") String comentario) {
        return postagemService.addComentario(idUser, idPostagem, comentario);
    }

    @DeleteMapping("/removerlike")
    public ResponseEntity<String> removerLike(@RequestParam("id_user") UUID idUser, @RequestParam("id_postagem") UUID idPostagem) {
        return postagemService.removerLike(idUser, idPostagem);
    }

    @GetMapping("/listarPostagemByIdUser")
    public List<Postagem> listarPostagemByIdUser(@RequestParam("id_user") UUID idUser) {
        return postagemService.listarPostagem(idUser);
    }

    @GetMapping("/verificarLike")
    public boolean verificarLike(@RequestParam("id_user") UUID id_user,@RequestParam("id_postagem") UUID id_postagem){
        return postagemService.verificarLike(id_user,id_postagem);
    }
}
