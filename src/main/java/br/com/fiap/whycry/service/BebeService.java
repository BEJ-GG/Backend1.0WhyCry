package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.repository.BebeRepository;

@Service
public class BebeService {
    
    @Autowired
    BebeRepository repository;

    public List<Bebe> listAll(){
        return repository.findAll();
    }
    public void save(Bebe bebe) {
        repository.save(bebe);
    }

    public Optional<Bebe> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
