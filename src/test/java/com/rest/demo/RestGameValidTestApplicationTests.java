package com.rest.demo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.demo.converters.GameConverter;
import com.rest.demo.converters.GameDtoConverter;
import com.rest.demo.dao.CrudGame;
import com.rest.demo.dao.CrudGenre;
import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;
import com.rest.demo.services.GenreService;
import com.rest.demo.enums.*;

@SpringBootTest
class RestGameValidTestApplicationTests {

	@Test
	void contextLoads() {

	}
	@Autowired
	GameConverter gc;
	@Autowired
	GameDtoConverter gcc;
	@Autowired
	CrudGame repository;
	@Autowired
	CrudGenre repository2;
	@Autowired
	GenreService genserv;
	@Test

	void converter() {
		ArrayList<GenreEnum> genEnu = new ArrayList<>();
		genEnu.add(GenreEnum.TERROR);
		//System.out.println(gc.getConverter(Game.class).convert(new GameDto((long) 1,"tre n","tre des", 2000,genEnu)));
		System.out.println(gcc.getConverter(GameDto.class).convert(repository.findById((long) 1).get()));
	}
	@Test

	void converter2() {
		System.out.println(gc.getConverter(Game.class).convert(new GameDto("tre n","tre des", 2000)));
	}
	@Test

	void genre() {
		System.out.println(repository2.findAll());
	}
	@Test

	void genre2() {
		System.out.println(genserv.findGenreByGenreEnum(GenreEnum.FPS));
	}
}
