package br.com.fiap.whycry.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;
import lombok.Data;

@Data
@Document(value = "choro")
public class Choro {

    @MongoId()
    private String id;
    
    @Field
    private String titulo;

    @Field
    private String descricao;
    
    @Field
    private Avaliacao avaliacao;
    
    @Field
    private Bebe bebe;

    @Field
    private Classificacao classficacao;



    
}
