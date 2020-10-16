package com.rest.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.demo.enums.GenreEnum;
import com.rest.demo.model.Genre;

public interface CrudGenre extends CrudRepository<Genre, Long> {
	public Genre findGenreByGenreEnum(GenreEnum genreEnum);

}
