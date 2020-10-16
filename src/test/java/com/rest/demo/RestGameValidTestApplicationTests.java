package com.rest.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.demo.converters.GameConverter;
import com.rest.demo.converters.GameDtoConverter;
import com.rest.demo.dao.CrudGame;
import com.rest.demo.dao.CrudGenre;
import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;

@SpringBootTest
class RestGameValidTestApplicationTests {

	@Test
	void contextLoads() {
		genre();

	}
	@Autowired
	GameConverter gc;
	
	@Autowired
	GameDtoConverter gcc;
	
	@Autowired
	CrudGame repository;
	CrudGenre repository2;

	
	void converter() {
		System.out.println(gc.getConverter(Game.class).convert(new GameDto("tre n","tre des", 2000)));
		System.out.println(gcc.getConverter(GameDto.class).convert(repository.findById((long) 1).get()));
	}
	
	void genre() {
		//System.out.println(repository.findByGenre(repository2.findById((long) 1).get()));
	}
}
