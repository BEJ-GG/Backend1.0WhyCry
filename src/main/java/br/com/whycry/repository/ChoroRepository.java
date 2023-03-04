package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Choro;

public interface ChoroRepository extends MongoRepository<Choro, String> {
    
}
