package com.example.log.cep.Logging.Cep.Service.integration;

import com.example.log.cep.Logging.Cep.Service.integration.dto.CepResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientCep {

    private RestTemplate restTemplate = new RestTemplate();

    public CepResponseDTO ClientCep(String cep) {
        try {
            return restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json", CepResponseDTO.class, cep);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
