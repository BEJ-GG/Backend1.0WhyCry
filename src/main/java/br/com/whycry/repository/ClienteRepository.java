package br.com.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.whycry.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {


}
