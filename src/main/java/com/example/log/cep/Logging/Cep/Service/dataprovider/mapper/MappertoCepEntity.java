package com.example.log.cep.Logging.Cep.Service.dataprovider.mapper;

import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntity;
import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntityOther;
import com.example.log.cep.Logging.Cep.Service.integration.dto.CepResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

public class MappertoCepEntity {

    public CepEntity toCepEntity(final CepResponseDTO cepResponseDTO) throws JsonProcessingException {
        CepEntity cepEntity = new CepEntity();
        cepEntity.setDateCreated(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        cepEntity.setCep(objectMapper.writeValueAsString(cepResponseDTO));
        return cepEntity;
    }

    public CepEntityOther toCepEntityOther(final CepResponseDTO cepResponseDTO) throws JsonProcessingException {
        CepEntityOther cepEntity = new CepEntityOther();
        cepEntity.setDateCreated(LocalDateTime.now());
        ObjectMapper objectMapper = new ObjectMapper();
        cepEntity.setCep(objectMapper.writeValueAsString(cepResponseDTO));
        return cepEntity;
    }
}
