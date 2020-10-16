package com.rest.demo.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import com.rest.demo.dto.GameDto;
import com.rest.demo.enums.GenreEnum;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;
import com.rest.demo.services.GenreService;

@Component
public class GameConverter 
  implements ConverterFactory< GameDto,Game> {


	@Override
	public <T extends Game> Converter<GameDto, T> getConverter(Class<T> targetType) {
			return new GameDtoToGame();
	}

		
    private final class GameDtoToGame<T extends Game> implements Converter<GameDto, Game> {
    	@Autowired
    	GenreService g;
		@Override
		public Game convert(GameDto source) {
			List<Genre> list = new ArrayList<>();
			for (GenreEnum genree : source.getGenre()) {
				list.add(g.findGenreByGenreEnumm(genree));
			}
			
			return new Game(source.getId(),source.getName(),source.getDescription(),source.getYear());

		}


		}
    }



