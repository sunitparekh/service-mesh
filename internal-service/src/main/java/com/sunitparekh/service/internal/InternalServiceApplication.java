package com.sunitparekh.service.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
public class InternalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternalServiceApplication.class, args);
	}
}
