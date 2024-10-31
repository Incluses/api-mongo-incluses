package com.example.demo.service;

import com.example.demo.models.Postagem;
import com.example.demo.repository.PostagemRepository;
import lombok.AllArgsConstructor;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Base64;


@AllArgsConstructor
@Service
public class PostagemService {
    private final PostagemRepository postagemRepository;

    public Postagem criarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    // Listar todas as postagens
    public List<Postagem> listarPostagens() {
        return postagemRepository.findAll();
    }

    // Obter uma postagem por ID
    public Optional<Postagem> obterPostagem(UUID id) {
        return postagemRepository.findById(id);
    }

    // Deletar uma postagem
    public boolean deletarPostagem(UUID id) {
        if (postagemRepository.existsById(id)) {
            postagemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ResponseEntity<String> addLike(UUID idUser, UUID idPostagem) {

        Optional<Postagem> postagemOptional = postagemRepository.findById(idPostagem);

        if (postagemOptional.isPresent()) {
            Postagem postagem = postagemOptional.get();

            Postagem.Like novoLike = new Postagem.Like();
            novoLike.setPerfilId(idUser);
            novoLike.setDataLike(new Date());

            postagem.getLikes().add(novoLike);

            postagemRepository.save(postagem);
            return ResponseEntity.ok("Like adicionado com sucesso!");
        } else {
            throw new RuntimeException("Postagem não encontrada com o ID: " + idPostagem);
        }
    }

    public ResponseEntity<String> addComentario(UUID idUser, UUID idPostagem, String comentario) {
        Optional<Postagem> postagemOptional = postagemRepository.findById(idPostagem);

        if (postagemOptional.isPresent()) {
            Postagem postagem = postagemOptional.get();

            Postagem.Comentario novoComentario = new Postagem.Comentario();
            novoComentario.setPerfilId(idUser);
            novoComentario.setComentario(comentario);

            postagem.getComentarios().add(novoComentario);

            postagemRepository.save(postagem);
            return ResponseEntity.ok("Comentário adicionado com sucesso!");
        } else {
            throw new RuntimeException("Postagem não encontrada com o ID: " + idPostagem);
        }}

    public ResponseEntity<String> removerLike(UUID idUser, UUID idPostagem) {

        Optional<Postagem> postagemOptional = postagemRepository.findById(idPostagem);

        if (postagemOptional.isPresent()) {
            Postagem postagem = postagemOptional.get();

            for (int i = 0; i < postagem.getLikes().size(); i++) {
                if (postagem.getLikes().get(i).getPerfilId().equals(idUser)) {
                    postagem.getLikes().remove(i);
                    break;
                }
            }   postagemRepository.save(postagem);
            return ResponseEntity.ok("Like removido com sucesso!");
        } else {
            throw new RuntimeException("Postagem não encontrada com o ID: " + idPostagem);
        }
    }

    public List<Postagem> listarPostagem(UUID idUser) {
        Optional<List<Postagem>> postagemOptional = postagemRepository.findByPerfilId(idUser);
        if (postagemOptional.isPresent()) {
            return postagemOptional.get();
        } else {
            throw new RuntimeException("Postagem não encontrada com o ID: " + idUser);
        }}

    public boolean verificarLike(UUID idUser, UUID idPostagem) {
        Optional<Postagem> postagemOptional = postagemRepository.findById(idPostagem);
        if (postagemOptional.isPresent()) {
            Postagem postagem = postagemOptional.get();
            for (Postagem.Like like : postagem.getLikes()) {
                if (like.getPerfilId().equals(idUser)) {
                    return true;
                }
            }
        }
        return false;}

    }

