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
import br.com.fiap.whycry.model.Agenda;
import br.com.fiap.whycry.service.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/v1")
@Tag(name = "Agenda endpoint")
public class AgendaController {

	@Autowired
	public AgendaService agendaService;

	@Operation(summary = "Listando agendaa")
	@GetMapping("/agenda")
	public List<Agenda> listarAgenda() {
		return agendaService.listarAgenda();
	}

	@Operation(summary = "Incluindo agenda")
	@PostMapping("/agenda")
	public ResponseEntity<Agenda> incluirAgenda(@RequestBody @Valid Agenda agenda) {
		agendaService.incluirAgenda(agenda);
		return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
	}

	@Operation(summary = "Obtendo agenda por ID")
	@GetMapping("/agenda/{id}")
	public ResponseEntity<Agenda> buscarAgenda(@PathVariable String id) {
		Agenda agenda = this.agendaService.buscarAgenda(id);
		return ResponseEntity.status(HttpStatus.OK).body(agenda);
	}

	@Operation(summary = "Alterando agenda por ID")
	@PutMapping("/agenda/{id}")
	public Agenda alterarAgenda(@RequestBody Agenda agenda, @PathVariable String id) {
		return this.agendaService.alterarAgenda(agenda, id);
	}

	@Operation(summary = "Remover agenda por ID")
	@DeleteMapping("/agenda/{id}")
	public Optional<Agenda> destroy(@PathVariable String id) {
		return this.agendaService.removerAgenda(id);
	}
}
