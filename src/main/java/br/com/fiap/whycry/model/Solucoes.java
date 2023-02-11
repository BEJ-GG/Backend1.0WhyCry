package br.com.fiap.whycry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_STC_SOLUCOES")
public class Solucoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_solucao;

    @OneToOne
    @JoinColumn(name = "cd_classificacao")
    private Classificacao classificacao;

    private String nm_solucao;
    private String ds_solucao;

    public Solucoes() {
    }

    public Solucoes(Classificacao classificacao, String nm_solucao, String ds_solucao) {
        this.classificacao = classificacao;
        this.nm_solucao = nm_solucao;
        this.ds_solucao = ds_solucao;
    }

    public Long getCd_solucao() {
        return cd_solucao;
    }

    public void setCd_solucao(Long cd_solucao) {
        this.cd_solucao = cd_solucao;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getNm_solucao() {
        return nm_solucao;
    }

    public void setNm_solucao(String nm_solucao) {
        this.nm_solucao = nm_solucao;
    }

    public String getDs_solucao() {
        return ds_solucao;
    }

    public void setDs_solucao(String ds_solucao) {
        this.ds_solucao = ds_solucao;
    }

    @Override
    public String toString() {
        return "Solucoes [cd_solucao=" + cd_solucao + ", classificacao=" + classificacao + ", ds_solucao=" + ds_solucao
                + ", nm_solucao=" + nm_solucao + "]";
    }

}
