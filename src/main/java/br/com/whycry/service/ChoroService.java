package br.com.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.whycry.model.Avaliacao;
import br.com.whycry.model.Bebe;
import br.com.whycry.model.Choro;
import br.com.whycry.model.Classificacao;
import br.com.whycry.repository.AvaliacaoRepository;
import br.com.whycry.repository.BebeRepository;
import br.com.whycry.repository.ChoroRepository;
import br.com.whycry.repository.ClassificacaoRepository;
import br.com.whycry.repository.ClienteRepository;

@Service
public class ChoroService {

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	@Autowired
	BebeRepository bebeRepository;

	@Autowired
	ChoroRepository choroRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ClassificacaoRepository classificacaoRepository;

	public List<Choro> listarChoros() {
		return this.choroRepository.findAll();
	}

	public Choro incluirChoro(Choro choro) {
		Avaliacao avaliacao = this.avaliacaoRepository.findById(choro.getAvaliacao().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Avaliação não encontrado")));
		
		Bebe bebe = this.bebeRepository.findById(choro.getBebe().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Bebê não encontrado")));

		Classificacao classficacao = this.classificacaoRepository.findById(choro.getClassficacao().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Classificação não encontrada")));

		choro.setAvaliacao(avaliacao);
		choro.setBebe(bebe);
		choro.setClassficacao(classficacao);
		return this.choroRepository.save(choro);
	}

	public Choro alterarChoro(Choro choro, String id) {
		Choro choroDb = this.choroRepository.findById(choro.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Choro não encontrado")));

		choroDb.setAvaliacao(choro.getAvaliacao());
		choroDb.setBebe(choro.getBebe());
		choroDb.setClassficacao(choro.getClassficacao());
		choroDb.setDescricao(choro.getDescricao());

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
