package br.com.fiap.whycry.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(value = "agenda")
public class Agenda {

	@MongoId()
	private String id;

	
	@Field
	private String descricao;
	
	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy-HH:mm:ss")
	private LocalDateTime dataHrs;
	
	@Field
	private Bebe bebe;

}
