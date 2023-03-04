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
import br.com.whycry.model.Avaliacao;
import br.com.whycry.service.AvaliacaoService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Avaliação")
public class AvaliacaoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AvaliacaoController.class);

	@Autowired
	public AvaliacaoService avaliacaoService;

	@Operation(summary = "Listar avaliações")
	@GetMapping("/avaliacao")
	public List<Avaliacao> listarAvaliacoes() {
		try {
			LOGGER.info("Listagem de avaliações com sucesso");
			return this.avaliacaoService.listarAvaliacoes();
		} catch (Exception e) {
			LOGGER.info("A listagem da avaliações não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir Avaliação")
	@PostMapping("/avaliacao")
	public Avaliacao incluirAvaliacao(@RequestBody @Valid Avaliacao avaliacao) {
		try {
			LOGGER.info("Avaliação " + avaliacao + " incluida com sucesso");
			return this.avaliacaoService.incluirAvaliacao(avaliacao);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do avaliação " + avaliacao + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar avaliação por ID")
	@GetMapping("/avaliacao/{id}")
	public Avaliacao buscarAvaliacoes(@PathVariable String id) {
		try {
			LOGGER.info("Avaliação " + id + " foi encontrada com sucesso");
			return this.avaliacaoService.buscarAvaliacao(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca da avaliação " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar avalição")
	@PutMapping("/avaliacao/{id}")
	public Avaliacao alterarAvaliacao(@PathVariable String id, @RequestBody @Valid Avaliacao avaliacao) {
		try {
			LOGGER.info("Avaliação " + id + " foi alterada com sucesso");
			return this.avaliacaoService.alterarAvaliacao(avaliacao, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração da avaliação " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover avaliação")
	@DeleteMapping("/avaliacao/{id}")
	public Optional<Avaliacao> removerAvaliacao(@PathVariable String id) {
		try {
			LOGGER.info("Avaliação " + id + " foi removida com sucesso");
			return this.avaliacaoService.removerAvaliacao(id);
		} catch (ErrorException e) {
			LOGGER.info("A remoção da avaliação " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

}
