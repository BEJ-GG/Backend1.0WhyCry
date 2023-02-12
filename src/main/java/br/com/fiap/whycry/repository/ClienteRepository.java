package br.com.fiap.whycry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.fiap.whycry.model.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {


}
