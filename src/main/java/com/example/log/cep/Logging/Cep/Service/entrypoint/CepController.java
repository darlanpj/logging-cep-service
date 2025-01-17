package com.example.log.cep.Logging.Cep.Service.entrypoint;

import com.example.log.cep.Logging.Cep.Service.integration.ClientCep;
import com.example.log.cep.Logging.Cep.Service.integration.dto.CepResponseDTO;
import com.example.log.cep.Logging.Cep.Service.usecace.NoSqlLoggingUseCase;
import com.example.log.cep.Logging.Cep.Service.usecace.SqlLoggingUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CepController {

    private final ClientCep clientCep;
    private final SqlLoggingUseCase sqlLoggingUseCase;
    private final NoSqlLoggingUseCase noSqlLoggingUseCase;

    public CepController(ClientCep clientCep, SqlLoggingUseCase sqlLoggingUseCase, NoSqlLoggingUseCase noSqlLoggingUseCase) {
        this.clientCep = clientCep;
        this.sqlLoggingUseCase = sqlLoggingUseCase;
        this.noSqlLoggingUseCase = noSqlLoggingUseCase;
    }

    @Operation(summary = "Get cep information", description = "Returns a cep information an save Sql database")
    @Cacheable("cep")
    @GetMapping("/cep/{cep}")
    @ResponseBody
    public ResponseEntity<CepResponseDTO> getCep(@PathVariable String cep) throws JsonProcessingException {
        return sqlLoggingUseCase.execute(cep);
    }

    @Operation(summary = "Get cep information", description = "Returns a cep information an save NoSql database")
    @Cacheable("cep")
    @GetMapping("/cep2/{cep}")
    @ResponseBody
    public ResponseEntity<CepResponseDTO> getCep2(@PathVariable String cep) throws JsonProcessingException {
        return noSqlLoggingUseCase.execute(cep);
    }

}
