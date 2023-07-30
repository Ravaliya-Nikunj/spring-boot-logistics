package com.example.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogisticsApplication {

	public static void main(String[] args) {
		System.out.println("Logistic application running.....");
		SpringApplication.run(LogisticsApplication.class, args);
	}

}
