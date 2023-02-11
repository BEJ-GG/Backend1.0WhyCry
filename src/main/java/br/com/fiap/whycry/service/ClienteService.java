package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Cliente;
import br.com.fiap.whycry.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repository;

    public List<Cliente> listAll(){
        return repository.findAll();
    }

    public void save(Cliente task) {
        repository.save(task);
    }

    public Optional<Cliente> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
