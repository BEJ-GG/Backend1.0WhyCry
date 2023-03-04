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
import br.com.whycry.model.Choro;
import br.com.whycry.service.ChoroService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Choro")
public class ChoroController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChoroController.class);

	@Autowired
	public ChoroService choroService;

	@Operation(summary = "Listar choros")
	@GetMapping("/choro")
	public List<Choro> listarChoros() {
		try {
			LOGGER.info("Listagem de choro com sucesso");
			return this.choroService.listarChoros();
		} catch (ErrorException e) {
			LOGGER.info("A listagem da classificações não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir choro")
	@PostMapping("/choro")
	public Choro incluirChoro(@RequestBody @Valid Choro choro) {
		try {
			LOGGER.info("Choro " + choro + " incluido com sucesso");
			return this.choroService.incluirChoro(choro);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do choro " + choro + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar choro por ID")
	@GetMapping("/choro/{id}")
	public Choro buscarChoro(@PathVariable String id) {
		try {
			LOGGER.info("Choro " + id + " foi encontrada com sucesso");
			return this.choroService.buscarChoro(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca do choro " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar choro")
	@PutMapping("/choro/{id}")
	public Choro alterarChoro(@PathVariable String id, @RequestBody @Valid Choro choro) {
		try {
			LOGGER.info("Choro " + choro + " foi alterado com sucesso");
			return this.choroService.alterarChoro(choro, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração do choro " + choro + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover choro")
	@DeleteMapping("/choro/{id}")
	public Optional<Choro> removerChoro(@PathVariable String id) {
		try {
			LOGGER.info("Choro " + id + " foi removido com sucesso");
			return this.choroService.removerChoro(id);
		} catch (ErrorException e) {
			LOGGER.info("A remoção do choro " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

}
