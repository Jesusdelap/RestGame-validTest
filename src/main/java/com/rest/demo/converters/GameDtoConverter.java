package com.rest.demo.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.GameDto;
import com.rest.demo.enums.GenreEnum;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;

@Component
public class GameDtoConverter 
implements ConverterFactory< Game,GameDto> {

    	

	@Override
	public <T extends GameDto> Converter<Game, T> getConverter(Class<T> targetType) {
		// TODO Auto-generated method stub
		return new  GameToGameDto();
	}

    		
    
        private final class GameToGameDto<T extends GameDto> implements Converter<Game, GameDto> {

		@Override
		public GameDto convert(Game source) {
			List<GenreEnum> listgenre = new ArrayList<>();
			for (Genre  genre: source.getGenres()) {
				listgenre.add(genre.getGenreEnum());
			}
			return new GameDto(source.getIdgames(),source.getName(),source.getDescription(),source.getYear(),(ArrayList<GenreEnum>) listgenre);
		}

}





    }
