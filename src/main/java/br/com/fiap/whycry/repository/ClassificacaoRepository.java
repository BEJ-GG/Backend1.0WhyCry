package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Classificacao;

public interface ClassificacaoRepository extends JpaRepository<Classificacao, Long>{
    
}
