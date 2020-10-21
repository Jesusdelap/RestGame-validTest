package com.rest.demo.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.dto.StockDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;
import com.rest.demo.model.Stock;
@Component
public class StockToStockDto<T extends StockDto> implements Converter<Stock, StockDto> {

	@Autowired
	ShopDtoConverter shopConverter;
	@Autowired
	GameDtoConverter gameConverter;
	@Override
	public StockDto convert(Stock stock) {
		return new StockDto(stock.getId(),shopConverter.getConverter(ShopDto.class).convert(stock.getShops()),gameConverter.getConverter(GameDto.class).convert(stock.getGames()),stock.getStock());

	}
	
}