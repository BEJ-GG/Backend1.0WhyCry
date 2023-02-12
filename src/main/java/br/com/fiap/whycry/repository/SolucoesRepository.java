package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Solucoes;

public interface SolucoesRepository extends MongoRepository<Solucoes, String>{
    
}
