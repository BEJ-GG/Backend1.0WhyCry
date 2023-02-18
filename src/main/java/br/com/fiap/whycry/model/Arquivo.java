package br.com.fiap.whycry.model;

import java.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
@Document(value = "arquivo")
public class Arquivo {

	@MongoId
	private String id;

	@Field
	private String titulo;

	@Field
	private String descricao;

	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataArquivo;

	@Field
	private Bebe bebe;

}
