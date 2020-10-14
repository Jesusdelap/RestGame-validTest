package com.rest.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.dao.CrudGame;
import com.rest.demo.exception.GameDontExistException;
import com.rest.demo.model.Game;
import com.rest.demo.model.GameDto;
@Service
public class GameServiceJpa  {

	@Autowired
	CrudGame repository;
	
	//Game get
	public List<Game> findAll(){
		return (List<Game>) repository.findAll();
	}
	//Game post
	public boolean add(Game game) {
		repository.save(game);
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
	public boolean update(Long id,Game newGame) {
		if(repository.existsById(id) )
			throw new GameDontExistException();
		Game game = repository.findById(id).get();
		game.setName(newGame.getName());
		game.setDescription(newGame.getDescription());
		game.setYear(newGame.getYear());

		repository.save(game);
		return true;
	}
	// Encontrar por nombre
	public List<Game> getbyname(String name) {
		if(repository.findByName(name).isEmpty())
			throw new GameDontExistException();
		return repository.findByName(name);
	}
	// Encontrar por id
	public Game getById(long id) {
		System.out.println(repository.findById(id).get());
		if(repository.findById(id).isEmpty())
			throw new GameDontExistException();
			
		  return repository.findById(id).get();
	 }
	
		    

}
