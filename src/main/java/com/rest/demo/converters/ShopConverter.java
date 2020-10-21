package com.rest.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.ShopDto;
import com.rest.demo.model.Shop;
@Component
public class ShopConverter implements ConverterFactory< ShopDto,Shop> {


	@Override
	public <T extends Shop> Converter<ShopDto, T> getConverter(Class<T> targetType) {
			return new ShopDtoToShop();
	}

		
    private final class ShopDtoToShop<T extends Shop> implements Converter<ShopDto, Shop> {

		@Override
		public Shop convert(ShopDto source) {
			
			return new Shop(source.getIdshops(),source.getName(),source.getDireccion());
		}
    }
}
