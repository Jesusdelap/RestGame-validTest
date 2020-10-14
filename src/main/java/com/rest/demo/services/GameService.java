package com.rest.demo.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.demo.exception.GameDontExistException;
import com.rest.demo.model.GameDto;
import com.rest.demo.model.Genre;

@Service
public class GameService  implements IGameService{
	
	private HashMap<String, GameDto> games = new HashMap<String, GameDto>();
	
	public GameService(){
		ArrayList<Genre> g = new ArrayList<Genre>();
		g.add(Genre.PUZLE);
		ArrayList<Genre> g2 = new ArrayList<Genre>();
		g2.add(Genre.TPS);
		g2.add(Genre.MULTIJUGADOR);
		
		games.put("tetris", new GameDto("tetris","dsadsadsa", 1967, "anonimo",g));
		games.put("GTA5", new GameDto("GTA5","dsadsadsa", 2013, "rockstars",g2));
		games.put("tre n", new GameDto("tre n","tre des", 2000, "tre dev"));
		games.put("cua n", new GameDto("cua n","cua des", 2000, "cua dev"));

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
