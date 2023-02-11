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

import br.com.fiap.whycry.model.Agenda;
import br.com.fiap.whycry.service.AgendaService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Agenda endpoint")
@RestController
@RequestMapping("/api/agenda/")
public class AgendaController {
    
    @Autowired
    public AgendaService service;

    @GetMapping
    public List<Agenda> index(){
        return service.listAll();
    }

    @PostMapping
    public ResponseEntity<Agenda> create(@RequestBody @Valid Agenda agenda){
        service.save(agenda);
        return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
    }
    @GetMapping("{id}")
    public ResponseEntity<Agenda> show(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Agenda> update(@PathVariable Long id, @RequestBody @Valid Agenda newAgenda){
        // buscar a tarefa no BD
        Optional<Agenda> optional = service.getById(id);

        // verificar se existe usuario com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var agenda = optional.get();
        BeanUtils.copyProperties(newAgenda, agenda);
        agenda.setCd_agenda(id);

        // salvar no BD
        service.save(agenda);

        return ResponseEntity.ok(agenda);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Agenda> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
