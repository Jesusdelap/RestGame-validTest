package com.rest.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "shop_game")
public class ShopGameStock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "idshop_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "idshop")
	private Long idShop;
	
	@Column(name = "idgame")
	private Long idGame;

	private Integer stock;

	public ShopGameStock(Long id, Long idShop, Long idGame, Integer stock) {
		super();
		this.id = id;
		this.idShop = idShop;
		this.idGame = idGame;
		this.stock = stock;
	}

	public ShopGameStock() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdShop() {
		return idShop;
	}

	public void setIdShop(Long idShop) {
		this.idShop = idShop;
	}

	public Long getIdGame() {
		return idGame;
	}

	public void setIdGame(Long idGame) {
		this.idGame = idGame;
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
		return "ShopGameStock [id=" + id + ", idShop=" + idShop + ", idGame=" + idGame + ", stock=" + stock + "]";
	}
	
	
}
