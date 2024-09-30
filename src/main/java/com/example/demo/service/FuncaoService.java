package com.example.demo.service;

import com.example.demo.models.Funcao;
import com.example.demo.repository.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncaoService {
    @Autowired
    private FuncaoRepository funcaoRepository;

    // Criar uma nova função
    public Funcao criarFuncao(Funcao funcao) {
        return funcaoRepository.save(funcao);
    }

    // Listar todas as funções
    public List<Funcao> listarFuncoes() {
        return funcaoRepository.findAll();
    }

    // Obter uma função por ID
    public Optional<Funcao> obterFuncao(String id) {
        return funcaoRepository.findById(id);
    }

    // Deletar uma função
    public boolean deletarFuncao(String id) {
        if (funcaoRepository.existsById(id)) {
            funcaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
