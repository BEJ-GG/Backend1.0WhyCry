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
import br.com.whycry.model.Solucoes;
import br.com.whycry.service.SolucoesService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Soluções", description = "Endpoint para consulta e acessos ")
public class SolucoesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SolucoesController.class);

	@Autowired
	SolucoesService solucoesService;

	@Operation(summary = "Listar soluções")
	@GetMapping("/solucoes")
	public List<Solucoes> listarSolucoes() {
		try {
			LOGGER.info("Listagem de soluções com sucesso");
			return this.solucoesService.listarSolucoes();
		} catch (ErrorException e) {
			LOGGER.info("A listagem da soluções não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir soluções")
	@PostMapping("/solucoes")
	public Solucoes incluirSolucao(@RequestBody @Valid Solucoes solucao) {
		try {
			LOGGER.info("Solução " + solucao + " incluida com sucesso ");
			return this.solucoesService.incluirSolucoes(solucao);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão da solução " + solucao + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Buscar soluções por ID")
	@GetMapping("/solucoes/{id}")
	public Solucoes buscarSolucao(@PathVariable String id) {
		try {
			LOGGER.info("Solução " + id + " foi encontrada com sucesso");
			return this.solucoesService.buscarSolucoes(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca da solução " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar solução")
	@PutMapping("/solucoes/{id}")
	public Solucoes alterarSolucao(@PathVariable String id, @RequestBody @Valid Solucoes solucoes) {
		try {
			LOGGER.info("Solução " + id + " foi alterada com sucesso");
			return this.solucoesService.alterarSolucoes(solucoes, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração da solução " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover solução")
	@DeleteMapping("/solucoes/{id}")
	public Optional<Solucoes> removerSolucao(@PathVariable String id) {
		try {
			LOGGER.info("Solução " + id + " foi removida com sucesso");
			return this.solucoesService.removerSolucoes(id);
		} catch (ErrorException e) {
			LOGGER.info("A remoção da solução " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

}
