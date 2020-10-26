package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.dto.StockDto;
import com.rest.demo.model.Stock;
import com.rest.demo.services.IGameService;
import com.rest.demo.services.IShopService;
import com.rest.demo.services.IStockService;

@RestController
@RequestMapping("/stocks")
public class RestStocks {
	
	@Autowired
	IStockService  stockService;
	@Autowired
	IGameService  gameService;
	@Autowired
	IShopService  shopService;
	//busca los juegos en una tienda
	@GetMapping(value = "/findByShop")
	public ResponseEntity<Object> findByShop(@RequestParam("id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.findByGame(gameService.getById(id)));
	}
	
	//busca las tiendas en las que hay un juego
	@GetMapping(value = "/findByGame")
	public ResponseEntity<Object> findByGame(@RequestParam("id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.findByShop(shopService.findById(id)));
	}
	
	//Modifica el numero de articulos de un stock 
	@PostMapping(value = "/changeStockInt")
	public ResponseEntity<Object> changeStockInt(@RequestBody Long id, Integer amount) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.changeStockInt(id, amount));
	}
	
	//Retorna todos los stocks
	@GetMapping(value = "/stock")
	public ResponseEntity<List<StockDto>> getStock() {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.findAll());
	}
	
	//Añade stock
	@PutMapping(value = "/stock")
	public ResponseEntity<Object> getStock(@RequestBody StockDto stock) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.put(stock));
	}

	//Borra un stock por id
	@DeleteMapping(value = "/stock")
	public ResponseEntity<Object> deleteStock(@RequestParam("id")Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(stockService.delete(id));
	}
}
