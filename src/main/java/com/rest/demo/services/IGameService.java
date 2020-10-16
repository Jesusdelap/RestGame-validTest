package com.rest.demo.services;

import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;

public interface IGameService {
	
	public boolean add(GameDto game);
	public boolean delete(String name);
	public GameDto getbyname(String name);
	

}
