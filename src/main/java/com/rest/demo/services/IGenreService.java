package com.rest.demo.services;

import java.util.List;

import com.rest.demo.enums.GenreEnum;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;

public interface IGenreService {
	
	public List<Game> findGamesByGenre(Genre genre);
	public Genre findGenreByGenreEnumm(GenreEnum genreEnum);

	

}
