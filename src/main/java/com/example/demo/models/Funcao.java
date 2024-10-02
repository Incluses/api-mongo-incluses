package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "funcoes")
public class Funcao {
    @Id // Indica que este é o campo que representa o ID
    private String id; // Você pode usar String para o ID no MongoDB
    private String nome;
    private List<Integer> userIds;
}
