package br.com.fiap.whycry.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Soluções")
public class SolucoesController {

	@Autowired
	SolucoesService solucoesService;

	@Operation(summary = "Listar soluções")
	@GetMapping("/solucoes")
	public List<Solucoes> listarSolucoes() {
		return this.solucoesService.listarSolucoes();
	}

	@Operation(summary = "Incluir soluções")
	@PostMapping("/solucoes")
	public Solucoes incluirSolucao(@RequestBody @Valid Solucoes solucao) {
		return this.solucoesService.incluirSolucoes(solucao);
	}

	@Operation(summary = "Buscar soluções por ID")
	@GetMapping("/solucoes/{id}")
	public ResponseEntity<Solucoes> buscarSolucao(@PathVariable String id) {
		Solucoes solucoes = this.solucoesService.buscarSolucoes(id);
		return ResponseEntity.status(HttpStatus.OK).body(solucoes);
	}

	@Operation(summary = "Alterar solução")
	@PutMapping("/solucoes/{id}")
	public Solucoes alterarSolucao(@PathVariable String id, @RequestBody @Valid Solucoes solucoes) {

		return this.solucoesService.alterarSolucoes(solucoes, id);
	}

	@Operation(summary = "Remover solução")
	@DeleteMapping("/solucoes/{id}")
	public Optional<Solucoes> removerSolucao(@PathVariable String id) {

		return this.solucoesService.removerSolucoes(id);
	}

}
