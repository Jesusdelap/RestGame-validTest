package com.rest.demo.model;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.rest.demo.enums.GenreEnum;



@Entity
@Table(name = "games")
public class Game implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgames;
	@NotNull
	@Size(min=2, max=32)
	private String name;
	
	@Size(min=4, max=256)
	private String description;
	
	private int year;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
			name = "game_genre", 
			joinColumns = @JoinColumn(name = "idgame"),
			inverseJoinColumns = @JoinColumn(name = "idgenre")
	)
	private List<Genre> genres = new ArrayList<>() ; 
    
	
	public Game(Long idgames, @NotNull @Size(min = 2, max = 32) String name,
			@Size(min = 4, max = 256) String description, int year) {
		super();
		this.idgames = idgames;
		this.name = name;
		this.description = description;
		this.year = year;
	}

	public Game() {
		super();
	}
	
	
	
	public Game(Long idgames, @NotNull @Size(min = 2, max = 32) String name,
			@Size(min = 4, max = 256) String description, int year, List<Genre> genres) {
		super();
		this.idgames = idgames;
		this.name = name;
		this.description = description;
		this.year = year;
		this.genres = genres;
	}

	public Long getIdgames() {
		return idgames;
	}
	public void setIdgames(Long idgames) {
		this.idgames = idgames;
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
	
	public List<Genre> getGenres() {
		return genres;
	}
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Game [idgames=" + idgames + ", name=" + name + ", description=" + description + ", year=" + year
				+ ", genres=" + genres + "]";
	}


	



	
	
	

}
