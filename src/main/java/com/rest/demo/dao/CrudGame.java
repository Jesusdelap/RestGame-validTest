package com.rest.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;

public interface CrudGame extends CrudRepository<Game,Long> {

	public List<Game> findByName(String name);
	public List<Game> findByYear(int year);

}
