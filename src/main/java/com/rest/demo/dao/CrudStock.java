package com.rest.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;
import com.rest.demo.model.Stock;

public interface CrudStock extends CrudRepository<Stock, Long>{
	

 	public List<Stock> findByShops(Shop shops);
	public List<Stock> findByGames(Game games);
	public List<Stock> findByGamesAndShops(Game games,Shop shops);

	
}
