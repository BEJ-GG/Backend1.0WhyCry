package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Choro;

public interface ChoroRepository extends MongoRepository<Choro, String> {
    
}
