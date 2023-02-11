package br.com.fiap.whycry.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_agenda")
public class Agenda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cd_agenda;
    @ManyToOne
    @JoinColumn(name = "codigoBebe")
    private Bebe cd_bebe;
    @DateTimeFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
    private LocalDateTime dt_horario;
    private String ds_agenda;

    public Agenda() {
    }

    public Agenda(Bebe cd_bebe, LocalDateTime dt_horario, String ds_agenda) {
        this.cd_bebe = cd_bebe;
        this.dt_horario = dt_horario;
        this.ds_agenda = ds_agenda;
    }

    public Long getCd_agenda() {
        return cd_agenda;
    }

    public void setCd_agenda(Long cd_agenda) {
        this.cd_agenda = cd_agenda;
    }

    public Bebe getCd_bebe() {
        return cd_bebe;
    }

    public void setCd_bebe(Bebe cd_bebe) {
        this.cd_bebe = cd_bebe;
    }

    public LocalDateTime getDt_horario() {
        return dt_horario;
    }

    public void setDt_horario(LocalDateTime dt_horario) {
        this.dt_horario = dt_horario;
    }

    public String getDs_agenda() {
        return ds_agenda;
    }

    public void setDs_agenda(String ds_agenda) {
        this.ds_agenda = ds_agenda;
    }

    @Override
    public String toString() {
        return "Agenda [cd_agenda=" + cd_agenda + ", cd_bebe=" + cd_bebe + ", ds_agenda=" + ds_agenda + ", dt_horario="
                + dt_horario + "]";
    }
    
    

    

}
