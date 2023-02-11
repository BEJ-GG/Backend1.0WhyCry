package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Choro;
import br.com.fiap.whycry.repository.ChoroRepository;

@Service
public class ChoroService {

    @Autowired
    ChoroRepository repository;

    public List<Choro> listAll(){
        return repository.findAll();
    }

    public void save(Choro log) {
        repository.save(log);
    }

    public Optional<Choro> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
