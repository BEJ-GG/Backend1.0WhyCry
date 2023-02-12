package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Avaliacao;

public interface AvaliacaoRepository extends MongoRepository<Avaliacao, String> {
    
}
