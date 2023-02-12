package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Avaliacao;
import br.com.fiap.whycry.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {

	@Autowired
	AvaliacaoRepository avaliacaoRepository;

	public List<Avaliacao> listAll() {
		return this.avaliacaoRepository.findAll();
	}

	public Avaliacao incluirArquivo(Avaliacao avaliacao) {
		return this.avaliacaoRepository.save(avaliacao);
	}
	
	public Avaliacao alterarAvaliacao(Avaliacao avaliacao, String id) {
		return this.avaliacaoRepository.save(avaliacao);

	}

	public Avaliacao buscarAvaliacao(String id) {
		Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);

		return avaliacao.get();
	}

	public Optional<Avaliacao> removerAvaliacao(String id) {
		Optional<Avaliacao> avaliacao = this.avaliacaoRepository.findById(id);
		this.avaliacaoRepository.deleteById(id);
		return avaliacao;
	}

}
