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
import com.rest.demo.dao.CrudStock;
import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.model.Game;
import com.rest.demo.services.imp.GenreService;
import com.rest.demo.services.imp.ShopService;
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
	CrudStock repository4;
	@Autowired
	GenreService genserv;
	@Autowired
	ShopService shopService;
	
	/*@Test
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
	void shop() {
		System.out.println("shop---------- "+repository4.findAll());
	}
	
	
	@Test
	void shop() {
		ShopDto shop = new  ShopDto("Central","Plaza Fakenam");
		System.out.println("find all---------- "+shopService.findAll());
		System.out.println(" findById---------- "+shopService.findById((long) 1));
		System.out.println(" add---------- "+shopService.put(shop));
		System.out.println("findByName---------- "+shopService.findByName("Central"));
		shop =shopService.findByName("Central");
		shop.setName("Prueba");
		System.out.println("Edit---------- "+shopService.put(shop));
		System.out.println(" findByName---------- "+shopService.findByName("Prueba"));

		System.out.println(" Delete---------- "+shopService.delete(shop.getIdshops()));



	}*/
	@Test
	void shop() {
		System.out.println("shop---------- "+repository4.findAll());
	}
}
