package br.com.icaromartins.desafiopicpay.desafio_picpay_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class DesafioPicpayBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPicpayBackendApplication.class, args);
	}

}
