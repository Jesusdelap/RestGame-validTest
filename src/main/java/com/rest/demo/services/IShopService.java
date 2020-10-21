package com.rest.demo.services;

import java.util.List;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;

public interface IShopService {
		

		public List<ShopDto> findAll();
		public boolean put(ShopDto shop);
		public boolean delete(Long id);
		public ShopDto findByName(String name);
		public ShopDto findById(Long id);
	

}
