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

import br.com.fiap.whycry.model.Classificacao;
import br.com.fiap.whycry.service.ClassificacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Classificacao endpoint")
@RestController
@RequestMapping("/api/classificacao")
public class ClassificacaoController {

    @Autowired
    private ClassificacaoService service;

    @GetMapping
    public List<Classificacao> index(){
        return service.listAll();
    }
    @PostMapping
    public ResponseEntity<Classificacao> create(@RequestBody @Valid Classificacao cla){
        service.save(cla);
        return ResponseEntity.status(HttpStatus.CREATED).body(cla);
    }
    @GetMapping("{id}")
    public ResponseEntity<Classificacao> show(@PathVariable Long id) {
        return ResponseEntity.of(service.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Classificacao> update(@PathVariable Long id, @RequestBody @Valid Classificacao newClas){
        // buscar a tarefa no BD
        Optional<Classificacao> optional = service.getById(id);

        // verificar se existe usuario com esse id
        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        // atualizar os dados no objeto
        var clas = optional.get();
        BeanUtils.copyProperties(newClas, clas);
        clas.setCd_classificacao(id);

        // salvar no BD
        service.save(clas);

        return ResponseEntity.ok(clas);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id){

        Optional<Classificacao> optional = service.getById(id);

        if(optional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
