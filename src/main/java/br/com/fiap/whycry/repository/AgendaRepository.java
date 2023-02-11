package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    
}
