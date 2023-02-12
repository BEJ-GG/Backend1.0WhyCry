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
	private Bebe bebe;
	
	@Field
	private String nome;
	
	@Field
	private String descricao;
	
	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataArquivo;

}
