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

import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.service.BebeService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bebe endpoint")
@RestController
@RequestMapping("/api/bebe")
public class BebeController {
    
    @Autowired
    public BebeService service;

    @GetMapping
    public List<Bebe> index(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Bebe> create(@RequestBody @Valid Bebe bebe){
        service.save(bebe);
        return ResponseEntity.status(HttpStatus.CREATED).body(bebe);
    }
    @GetMapping("{id}")
    public ResponseEntity<Bebe> show(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Bebe> update(@PathVariable Long id, @RequestBody @Valid Bebe newBebe){
        // buscar a tarefa no BD
        Optional<Bebe> optional = service.getById(id);

        // verificar se existe usuario com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var bebe = optional.get();
        BeanUtils.copyProperties(newBebe, bebe);
        bebe.setCd_bebe(id);

        // salvar no BD
        service.save(bebe);

        return ResponseEntity.ok(bebe);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Bebe> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
