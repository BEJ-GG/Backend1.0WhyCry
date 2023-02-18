package br.com.fiap.whycry.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.service.BebeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Bebê")
public class BebeController {

	@Autowired
	public BebeService bebeService;

	@Operation(summary = "Incluir bebe")
	@GetMapping("/bebe")
	public List<Bebe> listarBebes() {
		return this.bebeService.listarBebes();
	}

	@Operation(summary = "Incluir bebe")
	@PostMapping("/bebe")
	public Bebe incluirBebe(@RequestBody Bebe bebe) {
		return this.bebeService.incluirBebe(bebe);
	}

	@Operation(summary = "Buscar bebe por ID")
	@GetMapping("/bebe/{id}")
	public ResponseEntity<Bebe> buscarBebe(@PathVariable String id) {
		Bebe bebe = this.bebeService.buscarBebe(id);
		return ResponseEntity.status(HttpStatus.OK).body(bebe);
	}

	@Operation(summary = "Alterar bebe")
	@PutMapping("/bebe/{id}")
	public Bebe alterarBebe(@PathVariable String id, @RequestBody Bebe bebe) {
		return this.bebeService.alterarBebe(bebe, id);
	}

	@Operation(summary = "Remover bebe")
	@DeleteMapping("/bebe/{id}")
	public Optional<Bebe> removerBebe(@PathVariable String id) {

		return this.bebeService.removerBebe(id);
	}

}
