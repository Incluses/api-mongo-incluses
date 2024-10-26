package com.example.demo.repository;

import com.example.demo.models.Postagem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostagemRepository extends MongoRepository<Postagem, UUID> {
    Optional<List<Postagem>> findByPerfilId(UUID perfilId);
}
