package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "conversas")
public class Conversa {
    private UUID id; // Você pode usar String para o ID no MongoDB
    private String tipo; // "publico" ou "privado"
    private String nome; // Pode ser null
    private List<Participante> participantes; // Classe aninhada
    private Integer criadorId;
    private Date dataCriacao;
    private List<Mensagem> mensagem; // Classe aninhada

    // Getters e Setters

    public Conversa() {
        this.id = UUID.randomUUID();  // Gera um UUID automaticamente
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Participante {
        private UUID perfilId;
        private Date adicionadoEm;

        // Getters e Setters
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Mensagem {
        @Id
        private UUID perfilId;
        private String conteudo;
        private Date dataEnvio;

        // Getters e Setters
    }
}
