package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TwoDataSourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoDataSourcesApplication.class, args);
	}

}
