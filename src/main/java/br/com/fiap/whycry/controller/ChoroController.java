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

import br.com.fiap.whycry.model.Choro;
import br.com.fiap.whycry.service.ChoroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1")
@Tag(name = "Choro")
public class ChoroController {

	@Autowired
	ChoroService choroService;

	@Operation(summary = "Listar choros")
	@GetMapping
	public List<Choro> listarChoros() {
		return this.choroService.listarChoros();
	}

	@Operation(summary = "Incluir choro")
	@PostMapping("/choro")
	public Choro incluirChoro(@RequestBody @Valid Choro choro) {
		return this.choroService.incluirChoro(choro);
	}

	@Operation(summary = "Buscar choro por ID")
	@GetMapping("/choro/{id}")
	public ResponseEntity<Choro> buscarChoro(@PathVariable String id) {
		Choro choro = this.choroService.buscarChoro(id);
		return ResponseEntity.status(HttpStatus.OK).body(choro);
	}

	@Operation(summary = "Alterar choro")
	@PutMapping("/choro/{id}")
	public Choro alterarChoro(@PathVariable String id, @RequestBody @Valid Choro choro) {

		return this.choroService.alterarChoro(choro, id);
	}

	@Operation(summary = "Remover choro")
	@DeleteMapping("/choro/{id}")
	public Optional<Choro> removerChoro(@PathVariable String id) {

		return this.choroService.removerChoro(id);
	}

}
