package br.com.fiap.whycry.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1")
@Tag(name = "Classificacao")
public class ClassificacaoController {

	@Autowired
	private ClassificacaoService classificacaoService;

	@Operation(summary = "Listar classificações")
	@GetMapping("/classificacao")
	public List<Classificacao> listarClassificacoes() {
		return classificacaoService.listarClassificacoes();
	}

	@Operation(summary = "Incluir classificacao")
	@PostMapping("/classificacao")
	public Classificacao incluirClassificacao(@RequestBody @Valid Classificacao classificacao) {
		return this.classificacaoService.incluirClassificacao(classificacao);
	}

	@Operation(summary = "Buscar classificacao por ID")
	@GetMapping("/classificacao/{id}")
	public ResponseEntity<Classificacao> buscarClasssificacao(@PathVariable String id) {
		Classificacao classificacao = this.classificacaoService.buscarClassificacao(id);
		return ResponseEntity.status(HttpStatus.OK).body(classificacao);
	}

	@Operation(summary = "Alterar avaliacao")
	@PutMapping("/classificacao/{id}")
	public Classificacao alterarClassificacao(@PathVariable String id,
			@RequestBody @Valid Classificacao classificacao) {
		return this.alterarClassificacao(id, classificacao);
	}

	@Operation(summary = "Remover classificacao")
	@DeleteMapping("/classificacao/{id}")
	public Optional<Classificacao> removerClassificacao(@PathVariable String id) {

		return this.classificacaoService.removerClassificacao(id);
	}
}
