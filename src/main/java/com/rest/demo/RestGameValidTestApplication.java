package com.rest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.demo.dao.CrudGame;

@SpringBootApplication
public class RestGameValidTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestGameValidTestApplication.class, args);
	}
	 @Bean
	  public CommandLineRunner demo(CrudGame repository) {
	    return (args) -> {
	      // save a few customers
	      System.out.println("INIT Games --- : "+repository.findAll());

	    };
	  }

}
