package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Bebe;

public interface BebeRepository extends MongoRepository<Bebe, String> {
    
}
