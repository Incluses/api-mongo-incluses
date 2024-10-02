package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "postagem")
public class Postagem {
    @Id // Indica que este é o campo que representa o ID
    private String id; // Você pode usar String para o ID no MongoDB

    private Integer arquivoId;
    private Integer perfilId;
    private String titulo;
    private String legenda;
    private List<Like> likes; // Classe aninhada para representar likes
    private List<Comentario> comentarios; // Classe aninhada para representar comentários

    @Getter
    @Setter
    public static class Like {
        private Integer perfilId;
        private Date dataLike;

        // Getters e Setters
    }

    @Getter
    @Setter
    public static class Comentario {
        private Integer perfilId;
        private String comentario;

        // Getters e Setters
    }
}
