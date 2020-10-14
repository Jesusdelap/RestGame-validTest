package com.rest.demo.services;

import com.rest.demo.model.Game;
import com.rest.demo.model.GameDto;

public interface IGameService {
	
	public boolean add(GameDto game);
	public boolean delete(String name);
	public GameDto getbyname(String name);
	

}
