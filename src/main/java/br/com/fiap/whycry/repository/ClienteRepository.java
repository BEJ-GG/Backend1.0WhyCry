package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {


}
