package br.com.whycry.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.whycry.model.Bebe;
import br.com.whycry.service.BebeService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Bebê")
public class BebeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BebeController.class);

	@Autowired
	public BebeService bebeService;

	@Operation(summary = "Listar bebes")
	@GetMapping("/bebe")
	public List<Bebe> listarBebes() {
		try {
			LOGGER.info("Listagem de bebes com sucesso");
			return this.bebeService.listarBebes();
		} catch (Exception e) {
			LOGGER.info("A listagem dos bebes não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir bebe")
	@PostMapping("/bebe")
	public Bebe incluirBebe(@RequestBody Bebe bebe) {
		try {
			LOGGER.info("Bebe " + bebe + " incluido com sucesso");
			return this.bebeService.incluirBebe(bebe);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do bebe " + bebe + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar bebe por ID")
	@GetMapping("/bebe/{id}")
	public Bebe buscarBebe(@PathVariable String id) {
		try {
			LOGGER.info("Bebe" + id + " foi encontrada com sucesso");
			return this.bebeService.buscarBebe(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca do bebe " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar bebe")
	@PutMapping("/bebe/{id}")
	public Bebe alterarBebe(@PathVariable String id, @RequestBody Bebe bebe) {
		try {
			LOGGER.info("Bebe " + id + " foi alterado com sucesso");
			return this.bebeService.alterarBebe(bebe, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração do bebe " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover bebe")
	@DeleteMapping("/bebe/{id}")
	public Optional<Bebe> removerBebe(@PathVariable String id) {
		try {
			LOGGER.info("Choro " + id + " foi removido com sucesso");
			return this.bebeService.removerBebe(id);
		} catch (ErrorException e) {
			LOGGER.info("A remoção do bebe " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

}
