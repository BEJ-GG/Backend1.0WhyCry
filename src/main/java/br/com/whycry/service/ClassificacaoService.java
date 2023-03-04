package br.com.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.whycry.model.Classificacao;
import br.com.whycry.repository.ClassificacaoRepository;

@Service
public class ClassificacaoService {

	@Autowired
	ClassificacaoRepository classificacaoRepository;

	public List<Classificacao> listarClassificacoes() {
		return this.classificacaoRepository.findAll();
	}

	public Classificacao incluirClassificacao(Classificacao classificao) {
		return this.classificacaoRepository.save(classificao);
	}

	public Classificacao alterarClassificacao(Classificacao classificao, String id) {
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
