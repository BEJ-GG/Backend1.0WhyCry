package br.com.fiap.whycry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_avaliacao;
    private char ds_deu_certo;

    public Avaliacao() {
    }

    public Avaliacao(char ds_deu_certo) {
        this.ds_deu_certo = ds_deu_certo;
    }

    public Long getCd_avaliacao() {
        return cd_avaliacao;
    }
    public void setCd_avaliacao(Long cd_avaliacao) {
        this.cd_avaliacao = cd_avaliacao;
    }
    public char getDs_deu_certo() {
        return ds_deu_certo;
    }
    public void setDs_deu_certo(char ds_deu_certo) {
        this.ds_deu_certo = ds_deu_certo;
    }

    @Override
    public String toString() {
        return "Avaliacao [cd_avaliacao=" + cd_avaliacao + ", ds_deu_certo=" + ds_deu_certo + "]";
    }
    

    
}
