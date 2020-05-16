package com.modestack.addArtical.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.modestack")
@EntityScan("com.modestack.addArtical.model")
@EnableJpaRepositories("com.modestack.addArtical.dao")
public class AddArticalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddArticalApplication.class, args);
	}

}
