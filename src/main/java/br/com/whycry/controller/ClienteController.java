package br.com.whycry.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import br.com.whycry.model.Cliente;
import br.com.whycry.service.ClienteService;
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

		LOGGER.info("Listar clientes");
		return clienteService.listarClientes();
	}

	@Operation(summary = "Incluir cliente")
	@PostMapping("/cliente")
	public Cliente incluirCliente(@RequestBody @Valid Cliente cliente) {
		return this.clienteService.incluirCliente(cliente);
	}

	@Operation(summary = "Buscar cliente por ID")
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable String id) {
		Cliente cliente = this.clienteService.buscarCliente(id);
		return ResponseEntity.status(HttpStatus.OK).body(cliente);
	}

	@Operation(summary = "Alterar cliente")
	@PutMapping("/cliente/{id}")
	public Cliente alterarCliente(@PathVariable String id, @RequestBody @Valid Cliente cliente) {

		return this.clienteService.alterarCliente(cliente, id);
	}

	@Operation(summary = "Remover cliente")
	@DeleteMapping("/cliente/{id}")
	public Optional<Cliente> removerCliente(@PathVariable String id) {

		return this.clienteService.removerCliente(id);
	}
}
