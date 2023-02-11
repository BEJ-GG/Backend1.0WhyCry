package br.com.fiap.whycry.model;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_cliente;
    @Column(name = "nm_cliente")
    private String nm_cliente;
    @Column(name = "ds_email")
    private String ds_email;
    @Column(name = "ds_cpf")
    private String ds_cpf;
    private String ds_senha;
    private String num_telefone;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dt_nascimento;
    private String ds_genero;
    @Lob
    @Column
    private byte[] ds_imagem;

    public Cliente() {
    }

    public Cliente(Long cd_cliente, String nm_cliente, String ds_email, String ds_cpf, String ds_senha,
            String num_telefone, LocalDate dt_nascimento, String ds_genero, byte[] ds_imagem) {
        this.cd_cliente = cd_cliente;
        this.nm_cliente = nm_cliente;
        this.ds_email = ds_email;
        this.ds_cpf = ds_cpf;
        this.ds_senha = ds_senha;
        this.num_telefone = num_telefone;
        this.dt_nascimento = dt_nascimento;
        this.ds_genero = ds_genero;
        this.ds_imagem = ds_imagem;
    }

    public Cliente(@NotBlank(message = "Nome é obrigatório") String nm_cliente, String ds_email, String ds_cpf,
            String ds_senha, String num_telefone,
            LocalDate dt_nascimento, String ds_genero, byte[] ds_imagem) {
        this.nm_cliente = nm_cliente;
        this.ds_email = ds_email;
        this.ds_cpf = ds_cpf;
        this.ds_senha = ds_senha;
        this.num_telefone = num_telefone;
        this.dt_nascimento = dt_nascimento;
        this.ds_genero = ds_genero;
        this.ds_imagem = ds_imagem;
    }

    public Long getCd_cliente() {
        return cd_cliente;
    }

    public void setCd_cliente(Long cd_cliente) {
        this.cd_cliente = cd_cliente;
    }

    public String getNm_cliente() {
        return nm_cliente;
    }

    public void setNm_cliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public String getDs_email() {
        return ds_email;
    }

    public void setDs_email(String ds_email) {
        this.ds_email = ds_email;
    }

    public String getDs_cpf() {
        return ds_cpf;
    }

    public void setDs_cpf(String ds_cpf) {
        this.ds_cpf = ds_cpf;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public String getNum_telefone() {
        return num_telefone;
    }

    public void setNum_telefone(String num_telefone) {
        this.num_telefone = num_telefone;
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

    public byte[] getDs_imagem() {
        return ds_imagem;
    }

    public void setDs_imagem(byte[] ds_imagem) {
        this.ds_imagem = ds_imagem;
    }

    @Override
    public String toString() {
        return "Cliente [cd_cliente=" + cd_cliente + ", nm_cliente=" + nm_cliente + ", ds_email=" + ds_email
                + ", ds_cpf=" + ds_cpf + ", ds_senha=" + ds_senha + ", num_telefone=" + num_telefone
                + ", dt_nascimento=" + dt_nascimento + ", ds_genero=" + ds_genero + ", ds_imagem="
                + Arrays.toString(ds_imagem) + "]";
    }

}
