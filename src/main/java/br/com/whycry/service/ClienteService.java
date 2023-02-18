package br.com.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.whycry.model.Cliente;
import br.com.whycry.repository.ClienteRepository;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return this.clienteRepository.findAll();
    }

    public Cliente incluirCliente(Cliente cliente) {
    	return this.clienteRepository.save(cliente);
    }
    
	public Cliente alterarCliente(Cliente cliente, String id) {
		return this.clienteRepository.save(cliente);

	}

    public Cliente buscarCliente(String id) {
    	Optional<Cliente> cliente = this.clienteRepository.findById(id);
        return cliente.get();
    }

    public Optional<Cliente> removerCliente(String id) {
    	Optional<Cliente> cliente = this.clienteRepository.findById(id);
    	this.clienteRepository.deleteById(id);
    	return cliente;
    }

}
