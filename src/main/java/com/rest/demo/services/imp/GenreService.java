package com.rest.demo.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.dao.CrudGenre;
import com.rest.demo.enums.GenreEnum;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;
import com.rest.demo.services.IGenreService;
@Service
public class GenreService implements IGenreService {

	@Autowired
	CrudGenre crudGenre;

	@Override
	public List<Game> findGamesByGenre(Genre genre) {
		
		return genre.getGames();
	}

	@Override
	public Genre findGenreByGenreEnum(GenreEnum genreEnum) {
		
		return crudGenre.findGenreByGenreEnum(genreEnum);
	}

}
