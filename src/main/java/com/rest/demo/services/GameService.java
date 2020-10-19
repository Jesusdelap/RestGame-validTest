package com.rest.demo.services;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.converters.GameConverter;
import com.rest.demo.converters.GameDtoConverter;
import com.rest.demo.converters.GameToGameDTOMapper;
import com.rest.demo.dao.CrudGame;
import com.rest.demo.dto.GameDto;
import com.rest.demo.exception.GameDontExistException;
import com.rest.demo.model.Game;
@Service
public class GameService  implements IgameService{

	@Autowired
	CrudGame repository;
	@Autowired
	GameConverter gameConverter;
	@Autowired
	GameDtoConverter gameDtoConverter;
	
	//Game get
	public List<Game> findAll(){
		return (List<Game>) repository.findAll();
	}
	//Game post
	public boolean add( GameDto game) {
		
		
		repository.save(gameConverter.getConverter(Game.class).convert(game));
		return true;
	}
	//game delete
	public boolean delete(Long id) {
		if(repository.existsById(id))
			throw new GameDontExistException();
		repository.deleteById(id);
		return true;
	}
	//game update
	public boolean update(GameDto newGame) {
		if(repository.existsById(newGame.getId()) )
			throw new GameDontExistException();

		repository.save(gameConverter.getConverter(Game.class).convert(newGame));
		return true;
	}
	// Encontrar por nombre
	public GameDto getbyname(String name) {
		if(repository.findByName(name).isEmpty())
			throw new GameDontExistException();
		return gameDtoConverter.getConverter(GameDto.class).convert(repository.findByName(name).get(0));
	}
	// Encontrar por id
	public GameDto getById(long id) {
		System.out.println(repository.findById(id).get());
		if(repository.existsById(id))
			throw new GameDontExistException();		
		  return gameDtoConverter.getConverter(GameDto.class).convert(repository.findById(id).get());
	 }
	
		    

}
