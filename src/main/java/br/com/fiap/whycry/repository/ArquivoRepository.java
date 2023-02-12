package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Arquivo;

public interface ArquivoRepository extends MongoRepository<Arquivo, String>{
    
}
