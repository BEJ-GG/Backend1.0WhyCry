package br.com.fiap.whycry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.whycry.model.Bebe;

public interface BebeRepository extends JpaRepository<Bebe, Long> {
    
}
