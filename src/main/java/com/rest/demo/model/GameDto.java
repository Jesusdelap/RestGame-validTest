package com.rest.demo.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class GameDto {

	@NotNull
	@Size(min=2, max=32)
	private String name;
	
	@Size(min=4, max=256)
	private String description;
	
	private int year;
	
	private String developers;
	
	private ArrayList<Genre> genre;
	
	
	public GameDto(String name, String description, int year, String developers,ArrayList<Genre> generos) {
		super();
		this.name = name;
		this.description = description;
		this.year = year;
		this.developers = developers;
		this.genre = generos;
	}
	public GameDto(String name, String description, int year, String developers) {
		super();
		this.name = name;
		this.description = description;
		this.year = year;
		this.developers = developers;
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
	public String getdevelopers() {
		return developers;
	}
	public void setDevelopers(String developers) {
		this.developers = developers;
	}
	public ArrayList<Genre> getGeneros() {
		return genre;
	}
	public void setGeneros(ArrayList<Genre> generos) {
		this.genre = generos;
	}
	@Override
	public String toString() {
		return "Game [name=" + name + ", description=" + description + ", year=" + year + ", developers=" + developers
				+ ", generos=" + genre + "]";
	}
	
	
	
	

}
