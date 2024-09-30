package com.example.demo.repository;

import com.example.demo.models.Conversa;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConversaRepository extends MongoRepository<Conversa,Long> {
}
