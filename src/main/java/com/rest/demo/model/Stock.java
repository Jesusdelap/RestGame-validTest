package com.rest.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rest.demo.dto.GameDto;
import com.rest.demo.dto.ShopDto;
@Entity
@Table(name = "shop_game")
public class Stock implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idshop_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ElementCollection(targetClass = Shop.class)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idshop")
	private Shop shops ;
	
	@ElementCollection(targetClass = Game.class)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idgame")
	private Game games ;

	private Integer stock;

	public Stock(Long id, Shop shops, Game games, Integer stock) {
		super();
		this.id = id;
		this.shops = shops;
		this.games = games;
		this.stock = stock;
	}

	public Stock() {
		super();
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Shop getShops() {
		return shops;
	}

	public void setShops(Shop shops) {
		this.shops = shops;
	}

	public Game getGames() {
		return games;
	}

	public void setGames(Game games) {
		this.games = games;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", shops=" + shops + ", games=" + games + ", stock=" + stock + "]";
	}


	
}
