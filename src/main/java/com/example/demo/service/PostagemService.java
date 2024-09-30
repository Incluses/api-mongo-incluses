package com.example.demo.service;

import com.example.demo.models.Postagem;
import com.example.demo.repository.PostagemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Postagem> obterPostagem(String id) {
        return postagemRepository.findById(id);
    }

    // Deletar uma postagem
    public boolean deletarPostagem(String id) {
        if (postagemRepository.existsById(id)) {
            postagemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
