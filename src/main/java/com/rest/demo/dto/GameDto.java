package com.rest.demo.dto;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rest.demo.enums.GenreEnum;


public class GameDto {

	
	private Long id;
	@NotNull
	@Size(min=2, max=32)
	private String name;
	
	@Size(min=4, max=256)
	private String description;
	
	private int year;
	
	private ArrayList<GenreEnum> genre;
	
	public GameDto(Long id, @NotNull @Size(min = 2, max = 32) String name, @Size(min = 4, max = 256) String description,
			int year, ArrayList<GenreEnum> genre) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
		this.genre = genre;
	}
	public GameDto(String name, String description, int year ) {
		super();
		this.name = name;
		this.description = description;
		this.year = year;
	}
	public GameDto() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<GenreEnum> getGeneros() {
		return genre;
	}
	public void setGeneros(ArrayList<GenreEnum> generos) {
		this.genre = generos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ArrayList<GenreEnum> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<GenreEnum> genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "GameDto [id=" + id + ", name=" + name + ", description=" + description + ", year=" + year + ", genre="
				+ genre + "]";
	}

	
	
	
	

}
