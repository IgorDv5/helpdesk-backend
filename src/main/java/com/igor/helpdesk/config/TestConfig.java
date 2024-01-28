package com.igor.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.igor.helpdesk.services.DBService;

@Configuration //Anotação Para Classes de Configuração
@Profile("test") //Passando nome do profile
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instaciaDB() {
		this.dbService.instaciaDB();
	}

}	
