package com.igor.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.helpdesk.services.DBService;

@Configuration // Anotação Para Classes de Configuração
@Profile("dev") // Passando nome do profile
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;

	@Bean
	public boolean instaciaDB() {

		if (value.equals("create")) {
			this.dbService.instaciaDB();
		}
		return false;
	}

}
