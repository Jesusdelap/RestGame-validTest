package com.rest.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.dto.GameDto;
import com.rest.demo.enums.GenreEnum;
import com.rest.demo.exception.ValueException;
import com.rest.demo.model.Game;
import com.rest.demo.model.Genre;
import com.rest.demo.services.GameService;
import com.rest.demo.services.GameServiceJpa;
import com.rest.demo.services.GenreService;
@RestController
@RequestMapping("/jpa")
public class RestGameJpa {
	
	@Autowired
	GameServiceJpa  gameService;
	@Autowired
	GenreService  genreService;
	
	//buscar un juego por su id
	@GetMapping(value = "/getGameById")
	public ResponseEntity<Object> getGameById(@RequestParam("id")Long id) {
	
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getById(id));
	}
	
	//buscar un juego por su nombre
	@GetMapping(value = "/getGameByName")
	public ResponseEntity<Object> getGameByName(@RequestParam("name")String name) {
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getbyname(name));
	}
	//Lista todos los juegos
	@GetMapping(value = "/game")
	public ResponseEntity<Object> getGame() {
		
		return ResponseEntity.status(HttpStatus.OK).body(gameService.findAll());
	}
	
	//Añade un juego 
	@PostMapping(value = "/game")
	public ResponseEntity<String> postGame (@RequestBody @Valid Game game,BindingResult result ) {
		if(result.getErrorCount()==0) {
			gameService.add(game);
			return ResponseEntity.status(HttpStatus.OK).body("Añadido");
		}
		throw new ValueException("Los campos tienen valores no permitidos ",result.getFieldErrors());
			

	}
	
	 //borra un juego al pasarle su nombre
	@DeleteMapping(value = "/game")
	public ResponseEntity<Boolean> deleteGame(@RequestParam("id")Long id) {
		gameService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	 //actualiza un juego
	@PutMapping(value = "/game")
	public ResponseEntity<String> putGame(@RequestBody GameDto game,BindingResult result) {
		if(result.getErrorCount()==0) {
			gameService.update(game);
			return ResponseEntity.status(HttpStatus.OK).body("Insertado correctamente");
		}
		throw new ValueException("Los campos tienen valores no permitidos ",result.getFieldErrors());
		
	}
	
	 
	@GetMapping(value = "/getgenerosbygame")
	public ResponseEntity<List<Game>> getGenre(@RequestBody GenreEnum genreE){
		
		
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findGamesByGenre(genreService.findGenreByGenreEnumm(genreE)));
	}
	
	
	

}
