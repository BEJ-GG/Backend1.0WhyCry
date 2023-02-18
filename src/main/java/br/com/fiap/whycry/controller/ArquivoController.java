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

import br.com.fiap.whycry.model.Arquivo;
import br.com.fiap.whycry.service.ArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Arquivo")
public class ArquivoController {

	@Autowired
	ArquivoService arquivoService;

	@Operation(summary = "Listar arquivos")
	@GetMapping("/arquivo")
	public List<Arquivo> listarArquivos() {
		return this.arquivoService.listarArquivos();
	}

	@Operation(summary = "Incluir arquivo")
	@PostMapping("/arquivo")
	public Arquivo incluirArquivos(@RequestBody @Valid Arquivo arquivo) {

		return this.arquivoService.incluirArquivo(arquivo);
	}

	@Operation(summary = "Buscar arquivo por ID")
	@GetMapping("/arquivo/{id}")
	public ResponseEntity<Arquivo> buscarArquivo(@PathVariable String id) {
		Arquivo arquivo = this.arquivoService.buscarArquivo(id);
		return ResponseEntity.status(HttpStatus.OK).body(arquivo);
	}

	@Operation(summary = "Alterar arquivo")
	@PutMapping("/arquivo/{id}")
	public Arquivo alterarArquivo(@PathVariable String id, @RequestBody Arquivo arquivo) {

		return this.arquivoService.alterarArquivo(arquivo, id);
	}

	@Operation(summary = "Remover arquivo")
	@DeleteMapping("/arquivo/{id}")
	public Optional<Arquivo> removerArquivo(@PathVariable String id) {

		return this.arquivoService.removerArquivo(id);
	}
}
