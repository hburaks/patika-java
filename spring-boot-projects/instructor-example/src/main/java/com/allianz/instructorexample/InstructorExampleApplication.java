package com.allianz.instructorexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InstructorExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(InstructorExampleApplication.class, args);
	}

}
