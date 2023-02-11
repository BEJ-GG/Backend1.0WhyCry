package br.com.fiap.whycry.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_bebe")
public class Bebe{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_bebe;
    @ManyToOne(optional = false)
    @JoinColumn(name = "codigoUsuario")
    private Cliente cd_cliente;
    private String nm_bebe;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_nascimento;
    private String ds_genero;

    public Bebe(Long cd_bebe, Cliente cd_cliente, String nm_bebe, LocalDate dt_nascimento, String ds_genero) {
        this.cd_bebe = cd_bebe;
        this.cd_cliente = cd_cliente;
        this.nm_bebe = nm_bebe;
        this.dt_nascimento = dt_nascimento;
        this.ds_genero = ds_genero;
    }

    public Bebe(Cliente cliente, String nm_bebe, LocalDate dt_nascimento, String ds_genero) {
        this.cd_cliente = cliente;
        this.nm_bebe = nm_bebe;
        this.dt_nascimento = dt_nascimento;
        this.ds_genero = ds_genero;
    }

    public Bebe(){
        
    }

    public Long getCd_bebe() {
        return cd_bebe;
    }

    public void setCd_bebe(Long cd_bebe) {
        this.cd_bebe = cd_bebe;
    }

    public Cliente getCd_cliente() {
        return cd_cliente;
    }

    public void setCd_cliente(Cliente cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public String getNm_bebe() {
        return nm_bebe;
    }

    public void setNm_bebe(String nm_bebe) {
        this.nm_bebe = nm_bebe;
    }

    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(LocalDate dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDs_genero() {
        return ds_genero;
    }

    public void setDs_genero(String ds_genero) {
        this.ds_genero = ds_genero;
    }

    @Override
    public String toString() {
        return "Bebe [cd_bebe=" + cd_bebe + ", cliente=" + cd_cliente + ", ds_genero=" + ds_genero
                + ", dt_nascimento=" + dt_nascimento + ", nm_bebe=" + nm_bebe + "]";
    }

    
    


    



}