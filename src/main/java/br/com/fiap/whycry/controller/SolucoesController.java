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

import br.com.fiap.whycry.model.Solucoes;
import br.com.fiap.whycry.service.SolucoesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Solucoes endpoint")
@RestController
@RequestMapping("/api/solucoes")
public class SolucoesController {

	@Autowired
	SolucoesService service;

	@GetMapping
	public List<Solucoes> index() {
		return service.listAll();
	}

	@Operation(summary = "")
	@PostMapping
	public ResponseEntity<Solucoes> create(@RequestBody @Valid Solucoes solucao) {
		service.save(solucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(solucao);
	}

	@Operation(summary = "")
	@GetMapping("{id}")
	public ResponseEntity<Solucoes> show(@PathVariable Long id) {
		return ResponseEntity.of(service.getById(id));
	}

	@Operation(summary = "")
	@PutMapping("{id}")
	public ResponseEntity<Solucoes> update(@PathVariable Long id, @RequestBody @Valid Solucoes newSolucoes) {
		// buscar a tarefa no BD
		Optional<Solucoes> optional = service.getById(id);

		// verificar se existe usuario com esse id
		if (optional.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		// atualizar os dados no objeto
		var solucao = optional.get();
		BeanUtils.copyProperties(newSolucoes, solucao);
		solucao.setCd_solucao(id);

		// salvar no BD
		service.save(solucao);

		return ResponseEntity.ok(solucao);
	}

	@Operation(summary = "")
	@DeleteMapping("{id}")
	public ResponseEntity<Object> destroy(@PathVariable Long id) {

		Optional<Solucoes> optional = service.getById(id);

		if (optional.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		service.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
