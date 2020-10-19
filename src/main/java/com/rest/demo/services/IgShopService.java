package com.rest.demo.services;

import java.util.List;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;

public interface IgShopService {
		

		public List<Shop> findAll();
		public boolean add(Shop game);
		public boolean delete(Long id);
		public GameDto getbyname(String name);
		public Game getById(long id);
	

}
