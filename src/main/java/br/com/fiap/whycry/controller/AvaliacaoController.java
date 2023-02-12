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

import br.com.fiap.whycry.model.Avaliacao;
import br.com.fiap.whycry.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Avaliacao endpoint")
@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController {

	@Autowired
	AvaliacaoService service;

	@Operation(summary = "")
	@GetMapping
	public List<Avaliacao> index() {
		return service.listAll();
	}

	@Operation(summary = "")
	@PostMapping
	public ResponseEntity<Avaliacao> create(@RequestBody @Valid Avaliacao ava) {
		service.save(ava);
		return ResponseEntity.status(HttpStatus.CREATED).body(ava);
	}

	@Operation(summary = "")
	@GetMapping("{id}")
	public ResponseEntity<Avaliacao> show(@PathVariable Long id) {
		return ResponseEntity.of(service.getById(id));
	}

//	@Operation(summary = "")
//	@PutMapping("{id}")
//	public ResponseEntity<Avaliacao> update(@PathVariable Long id, @RequestBody @Valid Avaliacao newArquivo) {
//
//		return ResponseEntity.ok(avaliacao);
//	}

	@Operation(summary = "")
	@DeleteMapping("{id}")
	public ResponseEntity<Object> destroy(@PathVariable Long id) {

		Optional<Avaliacao> optional = service.getById(id);

		if (optional.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
