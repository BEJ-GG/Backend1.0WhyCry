package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Agenda;
import br.com.fiap.whycry.repository.AgendaRepository;

@Service
public class AgendaService {
    
    @Autowired
    AgendaRepository repository;

    public List<Agenda> listAll(){
        return repository.findAll();
    }

    public void save(Agenda agenda) {
        repository.save(agenda);
    }

    public Optional<Agenda> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
