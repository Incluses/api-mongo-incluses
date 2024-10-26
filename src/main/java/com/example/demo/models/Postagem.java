package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "postagem")
public class Postagem {
    @Id
    private UUID  id;

    private UUID arquivoId;
    private UUID perfilId;
    private String titulo;
    private String legenda;
    private List<Like> likes;
    private List<Comentario> comentarios;

    public Postagem() {
        this.id = UUID.randomUUID(); // Gerar como String
        this.likes = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }


    @Getter
    @Setter
    public static class Like {
        @Id
        private UUID id;
        private UUID perfilId;
        private Date dataLike;

    }

    @Getter
    @Setter
    public static class Comentario {
        @Id
        private UUID id;
        private UUID perfilId;
        private String comentario;

    }
}
