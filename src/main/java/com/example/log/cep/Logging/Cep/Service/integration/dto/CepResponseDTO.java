package com.example.log.cep.Logging.Cep.Service.integration.dto;

public record CepResponseDTO(String cep, String logradouro, String complemento, String bairro, String localidade, String uf,
                             String estado, String regiao, String ibge, String ddd) {
}
