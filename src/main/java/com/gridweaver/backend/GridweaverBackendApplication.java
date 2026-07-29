package com.gridweaver.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class GridweaverBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GridweaverBackendApplication.class, args);
	}

}
