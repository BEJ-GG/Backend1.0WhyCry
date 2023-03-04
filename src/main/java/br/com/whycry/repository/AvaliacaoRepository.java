package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Avaliacao;

public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {
    
}
