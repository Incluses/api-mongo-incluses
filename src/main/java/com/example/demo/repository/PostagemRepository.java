package com.example.demo.repository;

import com.example.demo.models.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, String> {
}
