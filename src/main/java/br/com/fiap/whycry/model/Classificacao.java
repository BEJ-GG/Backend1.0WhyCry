package br.com.fiap.whycry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_STC_CLASSIFICACAO")
public class Classificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_classificacao;
    private String nm_classificacao;

    public Classificacao() {
    }

    public Classificacao(Long cd_classificacao, String nm_classificacao) {
        this.cd_classificacao = cd_classificacao;
        this.nm_classificacao = nm_classificacao;
    }

    public Classificacao(String nm_classificacao) {
        this.nm_classificacao = nm_classificacao;
    }

    public Long getCd_classificacao() {
        return cd_classificacao;
    }

    public void setCd_classificacao(Long cd_classificacao) {
        this.cd_classificacao = cd_classificacao;
    }

    public String getNm_classificacao() {
        return nm_classificacao;
    }

    public void setNm_classificacao(String nm_classificacao) {
        this.nm_classificacao = nm_classificacao;
    }

    @Override
    public String toString() {
        return "Classificacao [cd_classificacao=" + cd_classificacao + ", nm_classificacao=" + nm_classificacao + "]";
    }

}
