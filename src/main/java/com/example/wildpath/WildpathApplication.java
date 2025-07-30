package com.example.wildpath;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
@SpringBootApplication
public class WildpathApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().load();

		System.setProperty("spring.datasource.username", dotenv.get("DB_USERNAME"));
		System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
		System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));

		SpringApplication.run(WildpathApplication.class, args);
	}

}
