package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Arquivo;
import br.com.fiap.whycry.repository.ArquivoRepository;

@Service
public class ArquivoService {
    
    @Autowired
    ArquivoRepository repository;

    public List<Arquivo> listAll(){
        return repository.findAll();
    }

    public void save(Arquivo arq){
        repository.save(arq);
    }
    
    public Optional<Arquivo> getById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
