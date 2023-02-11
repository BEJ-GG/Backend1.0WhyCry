package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Avaliacao;
import br.com.fiap.whycry.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
    
    @Autowired
    AvaliacaoRepository repository;

    public List<Avaliacao> listAll(){
        return repository.findAll();
    }

    public void save(Avaliacao arq){
        repository.save(arq);
    }
    
    public Optional<Avaliacao> getById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
