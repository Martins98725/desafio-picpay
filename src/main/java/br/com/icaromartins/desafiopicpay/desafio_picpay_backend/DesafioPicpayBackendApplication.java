package br.com.icaromartins.desafiopicpay.desafio_picpay_backend;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.kafka.config.TopicBuilder;

@EnableJdbcAuditing
@SpringBootApplication
public class DesafioPicpayBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPicpayBackendApplication.class, args);
	}

	@Bean
	NewTopic noticationTopic(){
		return TopicBuilder.name("transaction-notification ").build();
	}

}
