package com.jceloto7.teams_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jceloto7.shared_model.repository")
@EntityScan(basePackages = "com.jceloto7.shared_model.model.entity")
public class TeamsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeamsServiceApplication.class, args);
	}

}
