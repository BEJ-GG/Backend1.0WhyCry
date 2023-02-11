package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Classificacao;
import br.com.fiap.whycry.repository.ClassificacaoRepository;

@Service
public class ClassificacaoService {
    
    @Autowired
    ClassificacaoRepository repository;

    public List<Classificacao> listAll(){
        return repository.findAll();
    }
    public void save(Classificacao classifica) {
        repository.save(classifica);
    }

    public Optional<Classificacao> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
