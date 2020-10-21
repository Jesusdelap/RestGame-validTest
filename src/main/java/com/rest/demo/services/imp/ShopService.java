package com.rest.demo.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.converters.ShopConverter;
import com.rest.demo.converters.ShopDtoConverter;
import com.rest.demo.dao.CrudShop;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.model.Shop;
import com.rest.demo.services.IShopService;
@Service
public class ShopService implements IShopService {
	
	@Autowired
	CrudShop repository;
	
	@Autowired
	ShopConverter shopConverter;
	
	@Autowired
	ShopDtoConverter shopDtoConverter;
	 
	@Override
	public List<ShopDto> findAll() {
		List<Shop> list =(List<Shop>) repository.findAll();
		List<ShopDto> listDto =new ArrayList<>();
		for (Shop shop : list) {
			listDto.add(shopDtoConverter.getConverter(ShopDto.class).convert(shop));
		}
		return listDto;
	}

	@Override
	public boolean put(ShopDto shop) {
		repository.save(shopConverter.getConverter(Shop.class).convert(shop));
		return true;
	}
	
	@Override
	public boolean delete(Long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public ShopDto findByName(String name) {

		return shopDtoConverter.getConverter(ShopDto.class).convert(repository.findByName(name));
	}

	@Override
	public ShopDto findById(Long id) {

		return shopDtoConverter.getConverter(ShopDto.class).convert(repository.findById(id).get());
	}


	


}
