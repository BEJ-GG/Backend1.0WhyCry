package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    
}
