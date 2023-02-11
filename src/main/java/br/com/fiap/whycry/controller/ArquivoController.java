package br.com.fiap.whycry.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.whycry.model.Arquivo;
import br.com.fiap.whycry.service.ArquivoService;

@RestController
@RequestMapping("/api/arquivo")
public class ArquivoController {
    
    @Autowired
    ArquivoService service;

    @GetMapping
    public List<Arquivo> index(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Arquivo> create(@RequestBody @Valid Arquivo arq){
        service.save(arq);
        return ResponseEntity.status(HttpStatus.CREATED).body(arq);
    }
    @GetMapping("{id}")
    public ResponseEntity<Arquivo> show(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Arquivo> update(@PathVariable Long id, @RequestBody @Valid Arquivo newArquivo){
        // buscar a tarefa no BD
        Optional<Arquivo> optional = service.getById(id);

        // verificar se existe usuario com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var agenda = optional.get();
        BeanUtils.copyProperties(newArquivo, agenda);
        agenda.setCd_arquivo(id);

        // salvar no BD
        service.save(agenda);

        return ResponseEntity.ok(agenda);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Arquivo> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
