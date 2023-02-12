package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Classificacao;
import br.com.fiap.whycry.repository.ClassificacaoRepository;

@Service
public class ClassificacaoService {

	@Autowired
	ClassificacaoRepository classificacaoRepository;

	public List<Classificacao> listAll() {
		return this.classificacaoRepository.findAll();
	}

	public Classificacao incluirClassificacao(Classificacao classificao) {
		return this.classificacaoRepository.save(classificao);
	}

	public Classificacao alterarAvaliacao(Classificacao classificao, String id) {
		return this.classificacaoRepository.save(classificao);
	}

	public Classificacao buscarClassificacao(String id) {
		Optional<Classificacao> classificacao = this.classificacaoRepository.findById(id);

		return classificacao.get();
	}

	public Optional<Classificacao> removerClassificacao(String id) {
		Optional<Classificacao> classificacao = this.classificacaoRepository.findById(id);
		this.classificacaoRepository.deleteById(id);
		return classificacao;
	}

}
