package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long>{
    
}
