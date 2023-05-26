package br.edu.atitus.pooavancado.CadUsuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ConfigSwagger {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Cadastro de Usuários - POO Avançado")
						.description("Sistema criado em aula")
						.version("Versão 1.0.0")
						.contact(new Contact()
								.name("Developer Senior")
								.email("dev@atitus.edu.br")));
	}

}
