package br.com.fiap.whycry.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fiap.whycry.model.Agenda;
import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.repository.AgendaRepository;
import br.com.fiap.whycry.repository.BebeRepository;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository agendaRepository;

	@Autowired
	BebeRepository bebeRepository;

	public List<Agenda> listarAgenda() {
		return this.agendaRepository.findAll();
	}

	public Agenda incluirAgenda(Agenda agenda) {
		Bebe bebe = this.bebeRepository.findById(agenda.getBebe().getId())
				.orElseThrow(() -> new IllegalArgumentException(("Bebe não encontrado")));
		agenda.setBebe(bebe);
		return this.agendaRepository.save(agenda);
	}

	public Agenda alterarAgenda(Agenda agenda, String id) {
		Agenda agendaDb = this.agendaRepository.findById(agenda.getId())
				.orElseThrow(() -> new IllegalArgumentException(("Agenda não encontrada")));
		;

		agendaDb.setBebe(agenda.getBebe());
		agendaDb.setDataHora(agenda.getDataHora());
		agendaDb.setDescricao(agenda.getDescricao());

		return this.agendaRepository.save(agenda);

	}

	public Agenda buscarAgenda(String id) {
		Optional<Agenda> agenda = this.agendaRepository.findById(id);
		return agenda.get();
	}

	public Optional<Agenda> removerAgenda(String id) {
		Optional<Agenda> agenda = this.agendaRepository.findById(id);
		this.agendaRepository.deleteById(id);
		return agenda;

	}

}
