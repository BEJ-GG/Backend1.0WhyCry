package br.com.fiap.whycry.model;

import java.util.Date;
import javax.persistence.Lob;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Document(value = "cliente")
public class Cliente {

	@MongoId()
	private String id;

	@Field
	private String nome;

	@Field
	private String email;

	@Field
	private String telefone;
	
	@Field
	private String genero;
	
	@Field
	private String cpf;

	@Field
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dtNasc;

	@Lob
	@Field
	private byte[] imagem;

}
