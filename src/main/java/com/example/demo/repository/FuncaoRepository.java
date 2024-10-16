package com.example.demo.repository;

import com.example.demo.models.Funcao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncaoRepository extends MongoRepository<Funcao, String> {
}
