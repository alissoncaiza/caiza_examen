package com.example.asignacionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AsignacionServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AsignacionServiceApplication.class, args);
	}
}
