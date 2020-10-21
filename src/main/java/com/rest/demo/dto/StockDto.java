package com.rest.demo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.rest.demo.model.Game;
import com.rest.demo.model.Shop;

public class StockDto {
	
	private Long id;
	
	private ShopDto shops;

	private GameDto games;

	private Integer stock;

	public StockDto(Long id, ShopDto shops, GameDto games, Integer stock) {
		super();
		this.id = id;
		this.shops = shops;
		this.games = games;
		this.stock = stock;
	}

	public StockDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ShopDto getShops() {
		return shops;
	}

	public void setShops(ShopDto shops) {
		this.shops = shops;
	}

	public GameDto getGames() {
		return games;
	}

	public void setGames(GameDto games) {
		this.games = games;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "StockDto [id=" + id + ", shops=" + shops + ", games=" + games + ", stock=" + stock + "]";
	}
	
	
	
	
}
