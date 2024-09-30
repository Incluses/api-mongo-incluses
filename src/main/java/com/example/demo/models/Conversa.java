package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "conversas")
public class Conversa {
    private String id; // Você pode usar String para o ID no MongoDB
    private String tipo; // "publico" ou "privado"
    private String nome; // Pode ser null
    private List<Participante> participantes; // Classe aninhada
    private Integer criadorId;
    private Date dataCriacao;
    private List<Mensagem> mensagem; // Classe aninhada

    // Getters e Setters

    public static class Participante {
        private Integer perfilId;
        private Date adicionadoEm;

        // Getters e Setters
    }

    public static class Mensagem {
        private Integer perfilId;
        private String conteudo;
        private Date dataEnvio;

        // Getters e Setters
    }
}
