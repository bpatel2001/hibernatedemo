package com.bpatel2001.hibernatedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Bean
//	Will be executed after the Spring Beans have been loaded
	public CommandLineRunner commandLineRunner(String[] args) {
//		Java Lambda Expression
		return runner -> {
			System.out.println("Hello World!");
		};
	}
}
