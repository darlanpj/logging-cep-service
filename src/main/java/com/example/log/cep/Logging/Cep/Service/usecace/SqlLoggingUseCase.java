package com.example.log.cep.Logging.Cep.Service.usecace;


import com.example.log.cep.Logging.Cep.Service.dataprovider.SqlLoggingRepository;
import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntity;
import com.example.log.cep.Logging.Cep.Service.dataprovider.mapper.MappertoCepEntity;
import com.example.log.cep.Logging.Cep.Service.integration.ClientCep;
import com.example.log.cep.Logging.Cep.Service.integration.dto.CepResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SqlLoggingUseCase {

    private final ClientCep clientCep;
    private final SqlLoggingRepository repository;
    private final ObjectMapper objectMapper;

    public ResponseEntity<CepResponseDTO> execute(String cep) throws JsonProcessingException {
      return logCepBySql(cep);
    }

    public ResponseEntity<CepResponseDTO> logCepBySql(final String cep) throws JsonProcessingException {
        CepResponseDTO cepResponseDTO = clientCep.ClientCep(cep); //call cep service
        CepEntity cepEntity = new MappertoCepEntity().toCepEntity(cepResponseDTO);  //DTO to entity
        log.info("CepEntity: {}", cepEntity);
        repository.save(cepEntity); //save entity sql database
        log.info("Cep in SQL saved!");
        return ResponseEntity.ok().body(cepResponseDTO);
    }
}
