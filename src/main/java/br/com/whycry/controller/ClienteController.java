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
import br.com.whycry.model.Cliente;
import br.com.whycry.service.ClienteService;
import exceptions.ErrorException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/v1")
@Tag(name = "Cliente")
public class ClienteController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Listar clientes")
	@GetMapping("/cliente")
	public List<Cliente> listarClientes() {
		try {
			LOGGER.info("Lista de clientes com sucesso");
			return clienteService.listarClientes();
		} catch (ErrorException e) {
			LOGGER.info("A listagem da clientes não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Incluir cliente")
	@PostMapping("/cliente")
	public Cliente incluirCliente(@RequestBody @Valid Cliente cliente) {
		try {
			LOGGER.info("Clientes " + cliente + " incluido com sucesso");
			return this.clienteService.incluirCliente(cliente);
		} catch (ErrorException e) {
			LOGGER.info("A inclusão do cliente " + cliente + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Buscar cliente por ID")
	@GetMapping("/cliente/{id}")
	public Cliente buscarCliente(@PathVariable String id) {
		try {
			LOGGER.info("Cliente " + id + " foi encontrada com sucesso");
			return this.clienteService.buscarCliente(id);
		} catch (ErrorException e) {
			LOGGER.info("A busca da solução " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}

	@Operation(summary = "Alterar cliente")
	@PutMapping("/cliente/{id}")
	public Cliente alterarCliente(@PathVariable String id, @RequestBody @Valid Cliente cliente) {
		try {
			LOGGER.info("Cliente " + id + " foi alterado com sucesso");
			return this.clienteService.alterarCliente(cliente, id);
		} catch (ErrorException e) {
			LOGGER.info("A alteração da solução " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.BAD_REQUEST.getMessage(), ExceptionEnum.BAD_REQUEST.getStatus());
		}
	}

	@Operation(summary = "Remover cliente")
	@DeleteMapping("/cliente/{id}")
	public Optional<Cliente> removerCliente(@PathVariable String id) {
		try {
			LOGGER.info("Cliente " + id + " foi removido com sucesso");
			return this.clienteService.removerCliente(id);
		} catch (Exception e) {
			LOGGER.info("A remoção do cliente " + id + " não retornou nenhum resultado");
			throw new ErrorException(ExceptionEnum.NOT_FOUND.getMessage(), ExceptionEnum.NOT_FOUND.getStatus());
		}
	}
}
