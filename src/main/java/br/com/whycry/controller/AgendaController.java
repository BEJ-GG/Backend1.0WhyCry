package br.com.whycry.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.whycry.enums.ExceptionEnum;
import br.com.whycry.model.Agenda;
import br.com.whycry.service.AgendaService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Agenda")
public class AgendaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AgendaController.class);

	@Autowired
	public AgendaService agendaService;

	@Operation(summary = "Listando agendaa")
	@GetMapping("/agenda")
	public List<Agenda> listarAgendas() {
		try {
			LOGGER.info("Listagem de agendas com sucesso");
			return agendaService.listarAgenda();
		} catch (Exception e) {
			LOGGER.info("A listagem da classificações não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluindo agenda")
	@PostMapping("/agenda")
	public Agenda incluirAgenda(@RequestBody @Valid Agenda agenda) {
		try {
			LOGGER.info("Agenda " + agenda + " incluido com sucesso");
			return this.agendaService.incluirAgenda(agenda);
		} catch (Exception e) {
			LOGGER.info("A inclusão da agenda " + agenda + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}

	}

	@Operation(summary = "Obtendo agenda por ID")
	@GetMapping("/agenda/{id}")
	public Agenda buscarAgenda(@PathVariable String id) {
		try {
			LOGGER.info("Choro " + id + " foi encontrada com sucesso");
			return this.agendaService.buscarAgenda(id);
		} catch (Exception e) {
			LOGGER.info("A busca da agenda " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
		
	}

	@Operation(summary = "Alterando agenda por ID")
	@PutMapping("/agenda/{id}")
	public Agenda alterarAgenda(@RequestBody Agenda agenda, @PathVariable String id) {
		try {
			LOGGER.info("Agenda " + agenda + " foi alterado com sucesso");
			return this.agendaService.alterarAgenda(agenda, id);
		} catch (Exception e) {
			LOGGER.info("A alteração da agenda " + agenda + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover agenda por ID")
	@DeleteMapping("/agenda/{id}")
	public Optional<Agenda> removerAgenda(@PathVariable String id) {
		try {
			LOGGER.info("Agenda " + id + " foi removido com sucesso");
			return this.agendaService.removerAgenda(id);
		} catch (Exception e) {
			LOGGER.info("A remoção da agenda " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}
}
