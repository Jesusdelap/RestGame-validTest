package com.rest.demo.services;

import java.util.List;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;

public interface IGameServiceJpa {
	

	public List<Game> findAll();
	public boolean add(Game game);
	public boolean delete(Long id);
	public GameDto getbyname(String name);
	public Game getById(long id);
}
