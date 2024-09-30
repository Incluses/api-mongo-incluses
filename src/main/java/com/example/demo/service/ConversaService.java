package com.example.demo.service;

import com.example.demo.models.Conversa;
import com.example.demo.repository.ConversaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversaService {
    @Autowired
    private ConversaRepository conversaRepository;

    // Criar uma nova conversa
    public Conversa criarConversa(Conversa conversa) {
        return conversaRepository.save(conversa);
    }

    // Listar todas as conversas
    public List<Conversa> listarConversas() {
        return conversaRepository.findAll();
    }

    // Obter uma conversa por ID
    public Optional<Conversa> obterConversa(String id) {
        return conversaRepository.findById(id);
    }

    // Deletar uma conversa
    public boolean deletarConversa(String id) {
        if (conversaRepository.existsById(id)) {
            conversaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
