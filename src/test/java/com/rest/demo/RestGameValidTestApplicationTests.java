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
import com.rest.demo.dao.CrudShop;
import com.rest.demo.dao.CrudShopGameStock;
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
	CrudShop repository3;
	@Autowired
	CrudShopGameStock repository4;
	@Autowired
	GenreService genserv;
	@Test

	void converter() {

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

	void shopGameStock() {
		System.out.println("shopgamestock----- "+repository4.findAll());
	}
	
	@Test
	void shop() {
		System.out.println("shop---------- "+repository3.findAll());
	}
}
