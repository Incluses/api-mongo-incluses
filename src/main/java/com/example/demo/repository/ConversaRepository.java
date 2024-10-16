package com.example.demo.repository;

import com.example.demo.models.Conversa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConversaRepository extends MongoRepository<Conversa,String> {
}
