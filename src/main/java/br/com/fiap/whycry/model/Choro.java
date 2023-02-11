package br.com.fiap.whycry.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_STC_LOGCHORO")
public class Choro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_log;

    @OneToOne
    @JoinColumn(name = "cd_bebe")
    private Bebe cd_Bebe;

    @OneToOne
    @JoinColumn(name = "cd_classificacao")
    private Classificacao cd_Classificacao;

    @OneToOne
    @JoinColumn(name = "cd_avaliacao")
    private Avaliacao cd_Avaliacao;

    private String ds_choro;

    public Choro() {
    }

    public Choro(Bebe cd_Bebe, Classificacao cd_Classificacao, Avaliacao cd_Avaliacao, String ds_choro) {
        this.cd_Bebe = cd_Bebe;
        this.cd_Classificacao = cd_Classificacao;
        this.cd_Avaliacao = cd_Avaliacao;
        this.ds_choro = ds_choro;
    }


    public Long getCd_log() {
        return cd_log;
    }

    public void setCd_log(Long cd_log) {
        this.cd_log = cd_log;
    }

    public Bebe getCd_Bebe() {
        return cd_Bebe;
    }

    public void setCd_Bebe(Bebe cd_Bebe) {
        this.cd_Bebe = cd_Bebe;
    }

    public Classificacao getCd_Classificacao() {
        return cd_Classificacao;
    }

    public void setCd_Classificacao(Classificacao cd_Classificacao) {
        this.cd_Classificacao = cd_Classificacao;
    }

    public Avaliacao getCd_Avaliacao() {
        return cd_Avaliacao;
    }

    public void setCd_Avaliacao(Avaliacao cd_Avaliacao) {
        this.cd_Avaliacao = cd_Avaliacao;
    }

    public String getDs_choro() {
        return ds_choro;
    }

    public void setDs_choro(String ds_choro) {
        this.ds_choro = ds_choro;
    }

    @Override
    public String toString() {
        return "logChoro [cd_Avaliacao=" + cd_Avaliacao + ", cd_Bebe=" + cd_Bebe + ", cd_Classificacao="
                + cd_Classificacao + ", cd_log=" + cd_log + ", ds_choro=" + ds_choro + "]";
    }

}
