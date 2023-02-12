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

import br.com.fiap.whycry.model.Choro;
import br.com.fiap.whycry.service.ChoroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1")
@Tag(name = "Choro")
public class ChoroController {
    
    @Autowired
    ChoroService service;
    @Operation(summary = "")
    @GetMapping
    public List<Choro> index(){
        return service.listAll();
    }
    @Operation(summary = "")
    @PostMapping
    public ResponseEntity<Choro> create(@RequestBody @Valid Choro choro){
        service.save(choro);
        return ResponseEntity.status(HttpStatus.CREATED).body(choro);
    }
    @Operation(summary = "")
    @GetMapping("{id}")
    public ResponseEntity<Choro> show(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @Operation(summary = "")
    @PutMapping("{id}")
    public ResponseEntity<Choro> update(@PathVariable Long id, @RequestBody @Valid Choro newChoro){
        // buscar a tarefa no BD
        Optional<Choro> optional = service.getById(id);

        // verificar se existe usuario com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var choro = optional.get();
        BeanUtils.copyProperties(newChoro, choro);
        choro.setCd_log(id);

        // salvar no BD
        service.save(choro);

        return ResponseEntity.ok(choro);
    }
    @Operation(summary = "")
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Choro> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
