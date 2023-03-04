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
import br.com.whycry.model.Arquivo;
import br.com.whycry.service.ArquivoService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Arquivo")
public class ArquivoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArquivoController.class);

	@Autowired
	ArquivoService arquivoService;

	@Operation(summary = "Listar arquivos")
	@GetMapping("/arquivo")
	public List<Arquivo> listarArquivos() {
		try {
			LOGGER.info("Listagem de aquivos com sucesso");
			return this.arquivoService.listarArquivos();
		} catch (ErrorException e) {
			LOGGER.info("A listagem dos arquivos não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir arquivo")
	@PostMapping("/arquivo")
	public Arquivo incluirArquivos(@RequestBody @Valid Arquivo arquivo) {

		try {
			LOGGER.info("Choro " + arquivo + " incluido com sucesso");
			return this.arquivoService.incluirArquivo(arquivo);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do arquivo " + arquivo + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar arquivo por ID")
	@GetMapping("/arquivo/{id}")
	public Arquivo buscarArquivo(@PathVariable String id) {
		try {
			LOGGER.info("Arquivo " + id + " incluido com sucesso");
			return this.arquivoService.buscarArquivo(id);
		} catch (Exception e) {
			LOGGER.info("A inclusão do arquivo " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar arquivo")
	@PutMapping("/arquivo/{id}")
	public Arquivo alterarArquivo(@PathVariable String id, @RequestBody Arquivo arquivo) {
		try {
			LOGGER.info("Arquivo " + arquivo + " foi alterado com sucesso");
			return this.arquivoService.alterarArquivo(arquivo, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração do choro " + arquivo + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover arquivo")
	@DeleteMapping("/arquivo/{id}")
	public Optional<Arquivo> removerArquivo(@PathVariable String id) {
		try {
			LOGGER.info("Arquivo " + id + " foi removido com sucesso");
			return this.arquivoService.removerArquivo(id);
		} catch (Exception e) {
			LOGGER.info("A remoção do arquivo " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}
}
