package com.techno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages="com.techno.repository")
public class SpringBootMongoDbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbExampleApplication.class, args);
	}

}
