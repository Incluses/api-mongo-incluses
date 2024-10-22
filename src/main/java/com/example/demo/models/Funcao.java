package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "funcoes")
public class Funcao {
    @Id // Indica que este é o campo que representa o ID
    private UUID id; // Você pode usar String para o ID no MongoDB
    private String nome;
    private List<Integer> userIds;

    public Funcao() {
        this.id = UUID.randomUUID();  // Gera um UUID automaticamente
    }
}
