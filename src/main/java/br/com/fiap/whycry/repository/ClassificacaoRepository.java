package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Classificacao;

public interface ClassificacaoRepository extends MongoRepository<Classificacao, String>{
    
}
