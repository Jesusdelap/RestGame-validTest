package com.rest.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "shops")
public class Shop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idshops;
	
	private String name;
	
	private String direccion;

	public Shop(Long idshops, String name, String direccion) {
		super();
		this.idshops = idshops;
		this.name = name;
		this.direccion = direccion;
	}

	public Shop() {
		super();
	}

	public Long getIdshops() {
		return idshops;
	}

	public void setIdshops(Long idshops) {
		this.idshops = idshops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Shop [idshops=" + idshops + ", name=" + name + ", direccion=" + direccion + "]";
	}
	
	

	
}
