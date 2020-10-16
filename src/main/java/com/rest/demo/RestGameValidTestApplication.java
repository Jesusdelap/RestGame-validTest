package com.rest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.demo.dao.CrudGame;
import com.rest.demo.dao.CrudGenre;

@SpringBootApplication
public class RestGameValidTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGameValidTestApplication.class, args);
	}

}
