package com.rest.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
import com.rest.demo.exception.ValueException;
import com.rest.demo.services.IShopService;
import com.rest.demo.services.imp.GenreService;

@RestController
@RequestMapping("/shop")
public class RestShop {
	
	@Autowired
	IShopService  genreService;
	
	//buscar una tienda por su id
	@GetMapping(value = "/getShopById")
	public ResponseEntity<Object> getShopById(@RequestParam("id")Long id) {
	
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findById(id));
	}
	
	//buscar una tienda por su id
	@GetMapping(value = "/shop")
	public ResponseEntity<Object> getshop() {
	
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findAll());
	}
	//Añade/Edita  una tienda 
	@PostMapping(value = "/shop")
	public ResponseEntity<Object> postShop(@RequestBody @Valid ShopDto shop,BindingResult result ) {
		if(result.getErrorCount()==0)
			return ResponseEntity.status(HttpStatus.OK).body(genreService.put(shop));
		throw new ValueException("Los campos tienen valores no permitidos ",result.getFieldErrors());

	}
	//Borra una tienda
	@DeleteMapping(value = "/shop")
	public ResponseEntity<Boolean> deleteShop(@RequestParam("id") Long id ) {
		
		return ResponseEntity.status(HttpStatus.OK).body(genreService.delete(id));
	}
	
	//busca los juegos en una tienda
	@GetMapping(value = "/findByName")
	public ResponseEntity<Object> findByName(@RequestParam("name")String name) {
	
		return ResponseEntity.status(HttpStatus.OK).body(genreService.findByName(name));
	}
	
}
