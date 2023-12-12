package com.example.mongof1.Repositories;

import com.example.mongof1.Models.Racer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacerRepository extends MongoRepository<Racer, String> {
}