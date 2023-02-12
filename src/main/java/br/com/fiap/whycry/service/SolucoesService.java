package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Solucoes;
import br.com.fiap.whycry.repository.SolucoesRepository;

@Service
public class SolucoesService {

	@Autowired
	SolucoesRepository solucoesRepository;

	public List<Solucoes> listarSolucoes() {
		return solucoesRepository.findAll();
	}

	public Solucoes incluirSolucoes(Solucoes solucoes) {
		return this.solucoesRepository.save(solucoes);
	}

	public Solucoes alterarSolucoes(Solucoes solucoes, String id) {
		Solucoes solucoesDb = this.solucoesRepository.findById(solucoes.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Solução não encontrada")));

		solucoesDb.setClassificacao(solucoes.getClassificacao());
		solucoesDb.setDescricao(solucoes.getDescricao());
		solucoesDb.setNome(solucoes.getNome());

		return this.solucoesRepository.save(solucoes);

	}

	public Solucoes buscarSolucoes(String id) {
		Optional<Solucoes> solucoes = this.solucoesRepository.findById(id);
		return solucoes.get();
	}

	public Optional<Solucoes> removerSolucoes(String id) {
		Optional<Solucoes> solucoes = this.solucoesRepository.findById(id);
		this.solucoesRepository.deleteById(id);
		return solucoes;
	}

}
