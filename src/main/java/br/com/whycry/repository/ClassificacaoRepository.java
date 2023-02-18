package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Classificacao;

public interface ClassificacaoRepository extends MongoRepository<Classificacao, String>{
    
}
