package com.allianz.genericerpcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GenericErpCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericErpCrudApplication.class, args);
	}

}
