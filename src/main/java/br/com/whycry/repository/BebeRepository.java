package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Bebe;

public interface BebeRepository extends MongoRepository<Bebe, String> {
    
}
