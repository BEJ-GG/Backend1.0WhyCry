package br.com.whycry.model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(value = "bebe")
public class Bebe {

	@MongoId()
	private String id;

	@Field
	private String nome;

	@Field
	private String genero;

	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@Field
	private Cliente cliente;
}