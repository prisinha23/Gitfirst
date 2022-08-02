package com.priyesh.Learn1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Learn1Application {

	public static void main(String[] args) {
		SpringApplication.run(Learn1Application.class, args);
	}

}
