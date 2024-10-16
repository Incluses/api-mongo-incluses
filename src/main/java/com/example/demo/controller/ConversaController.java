package com.example.demo.controller;

import com.example.demo.models.Conversa;
import com.example.demo.service.ConversaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversa")
public class ConversaController {
    @Autowired
    private ConversaService conversaService;

    // Criar uma nova conversa
    @PostMapping("/inserir")
    public ResponseEntity<Conversa> criarConversa(@RequestBody Conversa conversa) {
        Conversa novaConversa = conversaService.criarConversa(conversa);
        return ResponseEntity.status(201).body(novaConversa);
    }
    // Listar todas as conversas
    @GetMapping
    public List<Conversa> listarConversas() {
        return conversaService.listarConversas();
    }

    // Obter uma conversa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Conversa> obterConversa(@PathVariable String id) {
        return conversaService.obterConversa(id)
                .map(conversa -> ResponseEntity.ok(conversa))
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar uma conversa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConversa(@PathVariable String id) {
        if (conversaService.deletarConversa(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
