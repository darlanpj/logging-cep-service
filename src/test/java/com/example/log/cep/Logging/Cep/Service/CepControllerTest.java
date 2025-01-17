package com.example.log.cep.Logging.Cep.Service;

import com.example.log.cep.Logging.Cep.Service.entrypoint.CepController;
import com.example.log.cep.Logging.Cep.Service.integration.dto.CepResponseDTO;
import com.example.log.cep.Logging.Cep.Service.integration.ClientCep;
import com.example.log.cep.Logging.Cep.Service.usecace.NoSqlLoggingUseCase;
import com.example.log.cep.Logging.Cep.Service.usecace.SqlLoggingUseCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CepControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ClientCep clientCep;

	@Mock
	private CepController cepController;

	@Mock
	private SqlLoggingUseCase sqlLoggingUseCase;

	@Mock
	private NoSqlLoggingUseCase noSqlLoggingUseCase;


	@BeforeEach
	void setUp() {
		cepController = new CepController(clientCep, sqlLoggingUseCase, noSqlLoggingUseCase);
	}

	@Test
	void testGetCep() throws Exception {
		String cep = "01001-000";
		CepResponseDTO mockResponse = new CepResponseDTO("01001-000", "Praça da Sé", "",
				"Sé", "São Paulo", "SP", "", "", "", "");

		Mockito.when(sqlLoggingUseCase.execute(cep)).thenReturn(ResponseEntity.ok(mockResponse));

		mockMvc.perform(get("/cep/{cep}", cep))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.cep").value(cep))
				.andExpect(jsonPath("$.logradouro").value("Praça da Sé"))
				.andExpect(jsonPath("$.bairro").value("Sé"))
				.andExpect(jsonPath("$.localidade").value("São Paulo"))
				.andExpect(jsonPath("$.uf").value("SP"));
	}
}
