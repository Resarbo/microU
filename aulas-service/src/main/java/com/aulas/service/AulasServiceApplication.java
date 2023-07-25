package com.aulas.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AulasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulasServiceApplication.class, args);
	}

}
