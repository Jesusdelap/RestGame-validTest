package com.rest.demo.controller;

import java.util.ArrayList;
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
import com.rest.demo.services.GameService;
@RestController
public class RestGame {
	
	@Autowired
	GameService  games;
	
	//buscar un juego por su nombre
	@GetMapping(value = "/getGameByName")
	public ResponseEntity<Object> getGameById(@RequestParam("nombre")String nombre) {
	
		return ResponseEntity.status(HttpStatus.OK).body(games.getbyname(nombre));
	}
	
	//Lista todos los juegos
	@GetMapping(value = "/game")
	public ResponseEntity<String> getGame() {
		
		return ResponseEntity.status(HttpStatus.OK).body(games.getGames().toString());
	}
	
	// Añade un juego 
	@PostMapping(value = "/game")
	public ResponseEntity<String> postGame (@RequestBody @Valid GameDto game,BindingResult result ) {
		if(result.getErrorCount()==0) {
			games.add(game);
			return ResponseEntity.status(HttpStatus.OK).body("Insertado correctamente");
		}
		throw new ValueException("Los campos tienen valores no permitidos ",result.getFieldErrors());
			

	}
	
	// borra un juego al pasarle su nombre
	@DeleteMapping(value = "/game")
	public ResponseEntity<Boolean> deleteGame(@RequestParam("name")String name) {
		games.delete(name);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	//actualiza un juego
	@PutMapping(value = "/game")
	public ResponseEntity<String> putGame(@RequestBody GameDto game,String oldgamename,BindingResult result) {
		games.getbyname(oldgamename);
		if(result.getErrorCount()==0) 
			return ResponseEntity.status(HttpStatus.OK).body("Insertado correctamente");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Count ERRORS: "+result.getErrorCount()+"/n"+result.getAllErrors());
		
	}
	
	//retorna los generos de un juego
	@GetMapping(value = "/getgenerosbygame")
	public ResponseEntity<ArrayList<GenreEnum>> getGenre(@RequestParam("name")String name){
		System.out.println(name);
		return ResponseEntity.status(HttpStatus.OK).body(games.getbyname(name).getGeneros());

	}
	
	
	

}
