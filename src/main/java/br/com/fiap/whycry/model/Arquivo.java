package br.com.fiap.whycry.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_arquivo")
public class Arquivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_arquivo;
    @OneToOne
    @JoinColumn(name = "codigoBebe")
    private Bebe bebe;
    private String nm_arquivo;
    private String ds_arquivo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_arquivo;
    
    public Arquivo() {
    }

    public Arquivo(Bebe bebe, String nm_arquivo, String ds_arquivo, LocalDate dt_arquivo) {
        this.bebe = bebe;
        this.nm_arquivo = nm_arquivo;
        this.ds_arquivo = ds_arquivo;
        this.dt_arquivo = dt_arquivo;
    }

    public Long getCd_arquivo() {
        return cd_arquivo;
    }

    public void setCd_arquivo(Long cd_arquivo) {
        this.cd_arquivo = cd_arquivo;
    }

    public Bebe getBebe() {
        return bebe;
    }

    public void setBebe(Bebe bebe) {
        this.bebe = bebe;
    }

    public String getNm_arquivo() {
        return nm_arquivo;
    }

    public void setNm_arquivo(String nm_arquivo) {
        this.nm_arquivo = nm_arquivo;
    }

    public String getDs_arquivo() {
        return ds_arquivo;
    }

    public void setDs_arquivo(String ds_arquivo) {
        this.ds_arquivo = ds_arquivo;
    }

    public LocalDate getDt_arquivo() {
        return dt_arquivo;
    }

    public void setDt_arquivo(LocalDate dt_arquivo) {
        this.dt_arquivo = dt_arquivo;
    }

    @Override
    public String toString() {
        return "Arquivo [bebe=" + bebe + ", cd_arquivo=" + cd_arquivo + ", ds_arquivo=" + ds_arquivo + ", dt_arquivo="
                + dt_arquivo + ", nm_arquivo=" + nm_arquivo + "]";
    }

    

    
}
