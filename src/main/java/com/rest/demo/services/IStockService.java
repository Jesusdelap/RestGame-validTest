package com.rest.demo.services;

import java.util.List;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.dto.StockDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;
import com.rest.demo.model.Stock;

public interface IStockService {
	
	public List<StockDto> findByShop(ShopDto shop);
	public List<StockDto> findByGame(GameDto game);
	public List<StockDto> findByGamesAndShops(GameDto games,ShopDto shops);
	public List<StockDto> findAll();
	public boolean put(StockDto shop);
	public boolean delete(Long id);
	public StockDto findById(Long id);

}
