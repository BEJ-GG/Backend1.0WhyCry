package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Agenda;

public interface AgendaRepository extends MongoRepository<Agenda, String>{
    
}
