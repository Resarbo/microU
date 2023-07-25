package com.docentes.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class DocentesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocentesServiceApplication.class, args);
	}

}
