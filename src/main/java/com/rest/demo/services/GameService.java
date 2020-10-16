package com.rest.demo.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.demo.dto.GameDto;
import com.rest.demo.enums.GenreEnum;
import com.rest.demo.exception.GameDontExistException;

@Service
public class GameService  implements IGameService{
	// que game tenga el nombre como indice es porque el dto lo modifique para utilizarlo con los restJpa
	private HashMap<String, GameDto> games = new HashMap<String, GameDto>();
	
	public GameService(){
		ArrayList<GenreEnum> g = new ArrayList<GenreEnum>();
		g.add(GenreEnum.PUZLE);
		ArrayList<GenreEnum> g2 = new ArrayList<GenreEnum>();
		g2.add(GenreEnum.TPS);
		g2.add(GenreEnum.MULTIJUGADOR);
		
		games.put("tetris", new GameDto((long) 1,"tetris","dsadsadsa", 1967,g));
		games.put("GTA5", new GameDto((long) 2,"GTA5","dsadsadsa", 2013, g2));
		games.put("tre n", new GameDto("tre n","tre des", 2000) );
		games.put("cua n", new GameDto("cua n","cua des", 2000));

	}

	public boolean add(GameDto game) {
		games.put(game.getName(), game);
		return true;
	}
	public boolean delete(String name) {
		
		games.remove(name);
		
		return true;
	}
	
	public GameDto getbyname(String name) {
		if(games.containsKey(name))
			return games.get(name);
		else
			throw new GameDontExistException("Juego No encontrado");
	}
	
	public HashMap<String, GameDto> getGames() {
		return games;
	}
	public void setGames(HashMap<String, GameDto> games) {
		this.games = games;
	}
	
	
	
}
