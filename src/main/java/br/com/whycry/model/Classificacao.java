package br.com.whycry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(value = "classificacao")
public class Classificacao {

    @MongoId()
    private String id;
    @Field
    private String nome;

  
}
