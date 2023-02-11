package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Solucoes;
import br.com.fiap.whycry.repository.SolucoesRepository;

@Service
public class SolucoesService {
    
    @Autowired
    SolucoesRepository repository;

    public List<Solucoes> listAll(){
        return repository.findAll();
    }

    public void save(Solucoes log) {
        repository.save(log);
    }

    public Optional<Solucoes> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
