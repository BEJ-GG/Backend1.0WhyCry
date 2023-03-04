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
import br.com.whycry.model.Classificacao;
import br.com.whycry.service.ClassificacaoService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Classificação")
public class ClassificacaoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClassificacaoController.class);

	@Autowired
	private ClassificacaoService classificacaoService;

	@Operation(summary = "Listar classificações")
	@GetMapping("/classificacao")
	public List<Classificacao> listarClassificacoes() {
		try {
			LOGGER.info("Lista de classificações com sucesso");
			return classificacaoService.listarClassificacoes();
		} catch (ErrorException e) {
			LOGGER.info("A listagem da classificações não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir classificação")
	@PostMapping("/classificacao")
	public Classificacao incluirClassificacao(@RequestBody @Valid Classificacao classificacao) {
		try {
			LOGGER.info("Classificação " + classificacao + " incluido com sucesso");
			return this.classificacaoService.incluirClassificacao(classificacao);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do cliente " + classificacao + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar classificação por ID")
	@GetMapping("/classificacao/{id}")
	public Classificacao buscarClasssificacao(@PathVariable String id) {
		try {
			LOGGER.info("Classficação " + id + " foi encontrada com sucesso");
			return this.classificacaoService.buscarClassificacao(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca da classificação " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar classificação")
	@PutMapping("/classificacao/{id}")
	public Classificacao alterarClassificacao(@PathVariable String id,
			@RequestBody @Valid Classificacao classificacao) {
		try {
			LOGGER.info("Classficação " + id + " foi alterado com sucesso");
			return this.classificacaoService.alterarClassificacao(classificacao, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração da classificação " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover classificaçao")
	@DeleteMapping("/classificacao/{id}")
	public Optional<Classificacao> removerClassificacao(@PathVariable String id) {
		try {
			LOGGER.info("Cliente " + id + " foi removido com sucesso");
			return this.classificacaoService.removerClassificacao(id);
		} catch (ErrorException e) {
			LOGGER.info("A remoção do cliente " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}
}
