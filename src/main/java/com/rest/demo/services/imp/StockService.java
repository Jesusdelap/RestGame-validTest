package com.rest.demo.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.converters.GameConverter;
import com.rest.demo.converters.GameDtoConverter;
import com.rest.demo.converters.ShopConverter;
import com.rest.demo.converters.StockDtoToStock;
import com.rest.demo.converters.StockToStockDto;
import com.rest.demo.dao.CrudGame;
import com.rest.demo.dao.CrudStock;
import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.dto.StockDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;
import com.rest.demo.model.Stock;
import com.rest.demo.services.IStockService;
@Service
public class StockService implements IStockService {


	@Autowired
	CrudStock repository;
	@Autowired
	StockToStockDto stockDtoConverter;
	@Autowired
	StockDtoToStock stockConverter;
	@Autowired
	ShopConverter shopConverter;
	@Autowired
	GameConverter gameConverter;
	@Override
	public List<StockDto> findByShop(ShopDto shop) {
		List<Stock> list = (List<Stock>) repository.findByShops(shopConverter.getConverter(Shop.class).convert(shop));
		List<StockDto> listDto =new ArrayList<>();
		for (Stock Stock2 : list) {
			listDto.add(stockDtoConverter.convert(Stock2));
		}
		return listDto;
	}

	@Override
	public List<StockDto> findByGame(GameDto game) {
		List<Stock> list = (List<Stock>) repository.findByGames(gameConverter.getConverter(Game.class).convert(game));
		List<StockDto> listDto =new ArrayList<>();
		for (Stock Stock2 : list) {
			listDto.add(stockDtoConverter.convert(Stock2));
		}
		return listDto;
	}

	@Override
	public List<StockDto> findByGamesAndShops(GameDto games, ShopDto shops) {
		List<Stock> list = (List<Stock>) repository.findByGamesAndShops(
				gameConverter.getConverter(Game.class).convert(games),
				shopConverter.getConverter(Shop.class).convert(shops));
		List<StockDto> listDto =new ArrayList<>();
		for (Stock Stock2 : list) {
			listDto.add(stockDtoConverter.convert(Stock2));
		}
		return listDto;
	}

	@Override
	public List<StockDto> findAll() {
		List<Stock> list = (List<Stock>) repository.findAll();
		List<StockDto> listDto =new ArrayList<>();
		for (Stock Stock2 : list) {
			listDto.add(stockDtoConverter.convert(Stock2));
		}
		return listDto;
	}

	@Override
	public boolean put(StockDto stock) {
		return 	put(stockConverter.convert(stock));
	}
	@Override
	public boolean put(Stock stock) {
		repository.save(stock);
		return true;
	}
	@Override
	public boolean delete(Long id) {
		
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;

	}

	@Override
	public StockDto findById(Long id) {

		return stockDtoConverter.convert(repository.findById(id).get());
	}

	@Override
	public boolean changeStockInt(Long id, Integer amount) {
		Stock  s = repository.findById(id).get();
		s.setStock(s.getStock()+amount);
		return put(s);
	}
	





}
