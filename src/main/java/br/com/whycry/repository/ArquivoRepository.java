package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Arquivo;

public interface ArquivoRepository extends MongoRepository<Arquivo, String>{
    
}
