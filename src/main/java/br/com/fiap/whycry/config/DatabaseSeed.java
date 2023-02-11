package br.com.fiap.whycry.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.whycry.model.Agenda;
import br.com.fiap.whycry.model.Arquivo;
import br.com.fiap.whycry.model.Avaliacao;
import br.com.fiap.whycry.model.Bebe;
import br.com.fiap.whycry.model.Choro;
import br.com.fiap.whycry.model.Classificacao;
import br.com.fiap.whycry.model.Cliente;
import br.com.fiap.whycry.model.Solucoes;
import br.com.fiap.whycry.repository.AgendaRepository;
import br.com.fiap.whycry.repository.ArquivoRepository;
import br.com.fiap.whycry.repository.AvaliacaoRepository;
import br.com.fiap.whycry.repository.BebeRepository;
import br.com.fiap.whycry.repository.ChoroRepository;
import br.com.fiap.whycry.repository.ClassificacaoRepository;
import br.com.fiap.whycry.repository.ClienteRepository;
import br.com.fiap.whycry.repository.SolucoesRepository;
import br.com.fiap.whycry.service.ClienteService;

@Configuration
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    ClienteRepository repository;
    @Autowired
    BebeRepository repository2;
    @Autowired
    AgendaRepository repository3;
    @Autowired
    ArquivoRepository repository4;
    @Autowired
    AvaliacaoRepository repository5;
    @Autowired
    ClassificacaoRepository repository6;
    @Autowired
    ChoroRepository repository7;
    @Autowired
    SolucoesRepository repository8;

    ClienteService service;

    public void run(String... args) {
        
        Cliente cliente1 = new Cliente("Gabriel", "gabrielrpg68@gmail.com", "471.922.635-85", "12345645Dantas", "(11)96359-8753", LocalDate.of(2000, 07, 22), "M", null);
        Cliente cliente2 = new Cliente("Joao Paulo", "JoaoPaulo@gmail.com", "653.985.632.58", "54321Paulo", "(11)98532-9654", LocalDate.of(1997, 02, 25), "M", null);
     

        repository.saveAll(List.of(cliente1, cliente2
        ));

        Bebe bebe1 = new Bebe(cliente1, "Valentina", LocalDate.of(2021, 05, 26), "F");
        Bebe bebe2 = new Bebe(cliente2, "Enzo", LocalDate.of(2022, 03, 26), "M");
        repository2.saveAll(List.of(bebe1, bebe2
        ));

        Agenda agenda1 =  new Agenda(bebe1, LocalDateTime.of(2022, 8, 29, 8, 26, 54), "Dar comida");
        repository3.saveAll(List.of(
            agenda1
        ));

        Arquivo arq1 = new Arquivo(bebe1, "Arquivo de detalhes", "Bebe precisa de atenção dobrada", LocalDate.of(2022, 06, 28));
        repository4.saveAll(List.of(arq1));

        Avaliacao ava1 = new Avaliacao('S');
        repository5.saveAll(List.of(ava1));

        Classificacao clasificacao1 = new Classificacao("Exemplo de classificação");
        repository6.saveAll(List.of(clasificacao1));

        Choro choro1 = new Choro(bebe1, clasificacao1, ava1, "Fome");
        repository7.saveAll(List.of(choro1));

        Solucoes solucao1 = new Solucoes(clasificacao1, "Alimente", "De comida para a criança");
        repository8.saveAll(List.of(solucao1));
    }

    
}
