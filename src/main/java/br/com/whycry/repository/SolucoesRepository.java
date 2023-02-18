package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Solucoes;

public interface SolucoesRepository extends MongoRepository<Solucoes, String>{
    
}
