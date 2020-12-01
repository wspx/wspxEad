package br.edu.wspx.ead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class WspxEadApplication {

	public static void main(String[] args) {
		SpringApplication.run(WspxEadApplication.class, args);
	}

}
