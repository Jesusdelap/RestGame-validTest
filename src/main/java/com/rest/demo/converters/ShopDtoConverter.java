/**
 * 
 */
package com.rest.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;

@Component
public class ShopDtoConverter implements ConverterFactory< Shop,ShopDto> {


		@Override
		public <T extends ShopDto> Converter<Shop, T> getConverter(Class<T> targetType) {
				return new ShopDtoToShop();
		}

			
	    private final class ShopDtoToShop<T extends ShopDto> implements Converter<Shop, ShopDto> {

			@Override
			public ShopDto convert(Shop source) {
				
				return new ShopDto(source.getIdshops(),source.getName(),source.getDireccion());

			}
	    }
}