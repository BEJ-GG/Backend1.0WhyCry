package br.com.fiap.whycry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

@Data
@Document(value = "classificacao")
public class Classificacao {

    @Field
    private String id;
    @Field
    private String nome;

  
}
