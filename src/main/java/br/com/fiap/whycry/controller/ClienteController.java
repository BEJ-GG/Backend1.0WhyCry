//package br.com.fiap.whycry.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.fiap.whycry.model.Cliente;
//import br.com.fiap.whycry.service.ClienteService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//
//@Tag(name = "Cliente endpoint")
//@RestController
//@RequestMapping("/api/cliente")
//public class ClienteController {
//    
//    @Autowired
//    private ClienteService service;
//
//    @Operation(summary = "")
//    @GetMapping
//    public List<Cliente> index(){
//        return service.listAll();
//    }
//    @Operation(summary = "")
//    @PostMapping
//    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente user){
//        service.save(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }
//    @Operation(summary = "")
//    @GetMapping("{id}")
//    public ResponseEntity<Cliente> show(@PathVariable Long id) {
//        return ResponseEntity.of(service.getById(id));
//    }
//    @Operation(summary = "")
//    @PutMapping("{id}")
//    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody @Valid Cliente newUser){
//        // buscar a tarefa no BD
//        Optional<Cliente> optional = service.getById(id);
//
//        // verificar se existe usuario com esse id
//        if(optional.isEmpty())
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        // atualizar os dados no objeto
//        var user = optional.get();
//        BeanUtils.copyProperties(newUser, user);
//        user.setCd_cliente(id);
//
//        // salvar no BD
//        service.save(user);
//
//        return ResponseEntity.ok(user);
//    }
//    @Operation(summary = "")
//    @DeleteMapping("{id}")
//    public ResponseEntity<Object> destroy(@PathVariable Long id){
//
//        Optional<Cliente> optional = service.getById(id);
//
//        if(optional.isEmpty())
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        service.deleteById(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//}
