package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.whycry.model.Arquivo;
import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.repository.ArquivoRepository;
import br.com.fiap.whycry.repository.BebeRepository;

@Service
public class ArquivoService {

	@Autowired
	ArquivoRepository arquivoRepository;

	@Autowired
	BebeRepository bebeRepository;

	public List<Arquivo> listarArquivos() {
		return arquivoRepository.findAll();
	}

	public Arquivo incluirArquivo(Arquivo arquivo) {
		Bebe bebe = this.bebeRepository.findById(arquivo.getBebe().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Bebe não encontrado")));
		
		
		arquivo.setBebe(bebe);
		return this.arquivoRepository.save(arquivo);
	}

	public Arquivo alterarArquivo(Arquivo arquivo, String id) {
		Arquivo arquivoDb = this.arquivoRepository.findById(arquivo.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Arquivo não encontrado")));

		arquivoDb.setBebe(arquivo.getBebe());
		arquivoDb.setDataArquivo(arquivo.getDataArquivo());
		arquivoDb.setDescricao(arquivo.getDescricao());
		arquivoDb.setTitulo(arquivo.getTitulo());

		return this.arquivoRepository.save(arquivo);

	}

	public Arquivo buscarArquivo(String id) {
		Optional<Arquivo> arquivo = this.arquivoRepository.findById(id);

		return arquivo.get();
	}

	public Optional<Arquivo> removerArquivo(String id) {
		Optional<Arquivo> arquivo = this.arquivoRepository.findById(id);
		this.arquivoRepository.deleteById(id);
		return arquivo;
	}
}
