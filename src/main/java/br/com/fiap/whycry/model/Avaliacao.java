package br.com.fiap.whycry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Data
@Document(value = "avaliacao")
public class Avaliacao {
    
    @MongoId()
    private String id;
    
    @Field
    private char descricao;

}