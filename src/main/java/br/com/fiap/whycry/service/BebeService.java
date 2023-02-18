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

		bebe.setCliente(cliente);
		return this.bebeRepository.save(bebe);
	}

	public Bebe alterarBebe(Bebe bebe, String id) {
		Bebe bebeDb = this.bebeRepository.findById(bebe.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Agenda não encontrada")));
		;

		bebeDb.setCliente(bebe.getCliente());
		bebeDb.setDataNascimento(bebe.getDataNascimento());
		bebeDb.setGenero(bebe.getGenero());
		bebeDb.setNome(bebe.getNome());

		return this.bebeRepository.save(bebe);

	}

	public Bebe buscarBebe(String id) {
		Optional<Bebe> bebe = this.bebeRepository.findById(id);
		return bebe.get();
	}

	public Optional<Bebe> removerBebe(String id) {
		Optional<Bebe> bebe = this.bebeRepository.findById(id);
		this.bebeRepository.deleteById(id);
		return bebe;
	}

}
