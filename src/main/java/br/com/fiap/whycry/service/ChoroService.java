package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Choro;
import br.com.fiap.whycry.repository.ChoroRepository;

@Service
public class ChoroService {

	@Autowired
	ChoroRepository choroRepository;

	public List<Choro> listAll() {
		return this.choroRepository.findAll();
	}

	public Choro incluirChoro(Choro choro) {
		return this.choroRepository.save(choro);
	}

	public Choro alterarChoro(Choro choro, String id) {
		Choro choroDb = this.choroRepository.findById(choro.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Choro não encontrada")));

		choroDb.setAvaliacao(choro.getAvaliacao());
		choroDb.setBebe(choro.getBebe());
		choroDb.setClassficacao(choro.getClassficacao());
		choroDb.setDsecricao(choro.getDsecricao());

		return this.choroRepository.save(choro);

	}

	public Choro buscarChoro(String id) {
		Optional<Choro> choro = this.choroRepository.findById(id);

		return choro.get();
	}

	public Optional<Choro> removerChoro(String id) {
		Optional<Choro> choro = this.choroRepository.findById(id);
		this.choroRepository.deleteById(id);
		return choro;
	}

}
