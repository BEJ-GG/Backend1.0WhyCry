package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.model.Cliente;
import br.com.fiap.whycry.repository.BebeRepository;
import br.com.fiap.whycry.repository.ClienteRepository;

@Service
public class BebeService {

	@Autowired
	BebeRepository bebeRepository;

	@Autowired
	ClienteRepository clienteRepository;

	public List<Bebe> listarBebes() {
		return this.bebeRepository.findAll();
	}

	public Bebe incluirBebe(Bebe bebe) {
		Cliente cliente = this.clienteRepository.findById(bebe.getCliente().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Cliente não encontrado")));
		;

		bebe.setCliente(cliente);
		return this.bebeRepository.save(bebe);
	}

	public Optional<Bebe> getById(Long id) {
		return this.bebeRepository.findById(id);
	}

	public void deleteById(Long id) {
		return this.bebeRepository.deleteById(id);
	}

}
