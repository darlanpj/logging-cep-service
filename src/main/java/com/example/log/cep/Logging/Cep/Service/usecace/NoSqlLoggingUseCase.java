package com.example.log.cep.Logging.Cep.Service.usecace;


import com.example.log.cep.Logging.Cep.Service.dataprovider.NoSqlLoggingRepository;
import com.example.log.cep.Logging.Cep.Service.dataprovider.entity.CepEntityOther;
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
public class NoSqlLoggingUseCase {

    private final ClientCep clientCep;
    private final NoSqlLoggingRepository repository;
    private final ObjectMapper objectMapper;

    public ResponseEntity<CepResponseDTO> execute(String cep) throws JsonProcessingException {
        return logCepByNoSql(cep);
    }

    public ResponseEntity<CepResponseDTO> logCepByNoSql(final String cep) throws JsonProcessingException {
        CepResponseDTO cepResponseDTO = clientCep.ClientCep(cep); //call cep service
        CepEntityOther cepEntity = new MappertoCepEntity().toCepEntityOther(cepResponseDTO);  //DTO to entity
        log.info("CepEntityOther: {}", cepEntity);
        repository.save(cepEntity); //save entity sql database
        log.info("Cep in NoSql saved!");
        return ResponseEntity.ok().body(cepResponseDTO);
    }
}
