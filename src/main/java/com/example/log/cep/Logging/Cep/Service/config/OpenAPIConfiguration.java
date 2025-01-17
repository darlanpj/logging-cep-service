package com.example.log.cep.Logging.Cep.Service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8090");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Darlan Jambersi");
        myContact.setEmail("darlanpj@gmail.com");

        Info information = new Info()
                .title("Logging Cep Service")
                .version("1.0")
                .description("Logging Cep Service")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
