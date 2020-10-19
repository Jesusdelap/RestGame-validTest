package com.rest.demo.services;

import java.util.List;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;

public interface IGameService {
	

	public List<GameDto> findAll();
	public boolean add(GameDto game);
	public boolean delete(Long id);
	public GameDto getbyname(String name);
	public GameDto getById(long id);
}
