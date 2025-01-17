package com.example.log.cep.Logging.Cep.Service.dataprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cep_audit")
public class CepEntityOther {

    @MongoId(FieldType.OBJECT_ID)
    private int id;

    private LocalDateTime dateCreated;

    private String cep;
}
