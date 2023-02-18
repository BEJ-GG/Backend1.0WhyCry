package br.com.fiap.whycry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.Data;

@Data
@Document(value = "solucoes")
public class Solucoes {

	@MongoId()
	private String id;

	@Field
	private String nome;

	@Field
	private String descricao;

	@Field
	private Classificacao classificacao;

}
