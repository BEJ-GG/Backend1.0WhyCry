package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Agenda;

public interface AgendaRepository extends MongoRepository<Agenda, String>{
    
}
