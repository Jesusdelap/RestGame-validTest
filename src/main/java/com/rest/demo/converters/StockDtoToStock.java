package com.rest.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.StockDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;
import com.rest.demo.model.Stock;

@Component
public class StockDtoToStock<T extends Stock> implements Converter<StockDto, Stock> {

	@Autowired
	ShopConverter shopConverter;
	@Autowired
	GameConverter gameConverter;
	@Override
	public Stock convert(StockDto stockDto) {
		

		return new Stock(stockDto.getId(),shopConverter.getConverter(Shop.class).convert(stockDto.getShops()),gameConverter.getConverter(Game.class).convert(stockDto.getGames()),stockDto.getStock());

	}
	
}