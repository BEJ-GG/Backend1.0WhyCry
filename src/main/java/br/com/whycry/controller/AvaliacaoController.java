package br.com.whycry.controller;

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

import br.com.whycry.model.Avaliacao;
import br.com.whycry.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Avaliação")
public class AvaliacaoController {

	@Autowired
	public AvaliacaoService avaliacaoService;

	@Operation(summary = "Listar Avaliações")
	@GetMapping("/avaliacao")
	public List<Avaliacao> listarAvaliacoes() {
		return this.avaliacaoService.listarAvaliacoes();
	}

	@Operation(summary = "Incluir Avaliação")
	@PostMapping("/avaliacao")
	public Avaliacao incluirAvaliacao(@RequestBody @Valid Avaliacao avaliacao) {

		return this.avaliacaoService.incluirAvaliacao(avaliacao);
	}

	@Operation(summary = "Buscar avaliação por ID")
	@GetMapping("/avaliacao/{id}")
	public ResponseEntity<Avaliacao> buscarAvaliacoes(@PathVariable String id) {
		Avaliacao avaliacao = this.avaliacaoService.buscarAvaliacao(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(avaliacao);
	}

	@Operation(summary = "Alterar avalição")
	@PutMapping("/avaliacao/{id}")
	public Avaliacao alterarAvaliacao(@PathVariable String id, @RequestBody @Valid Avaliacao avaliacao) {

		return this.avaliacaoService.alterarAvaliacao(avaliacao, id);
	}

	@Operation(summary = "Remover avaliação")
	@DeleteMapping("/avaliacao/{id}")
	public Optional<Avaliacao> removerAvaliacao(@PathVariable String id) {

		return this.avaliacaoService.removerAvaliacao(id);
	}

}
