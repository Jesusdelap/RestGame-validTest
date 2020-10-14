package com.rest.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgames;
	@NotNull
	@Size(min=2, max=32)
	private String name;
	
	@Size(min=4, max=256)
	private String description;
	
	private int year;
    /*@Enumerated(value = EnumType.STRING)
	@ElementCollection(targetClass = Genre.class) 
	@CollectionTable(
			name = "game_genre", 
			joinColumns = @JoinColumn(name = "idgame")
	)
	@Column(name = "idgenre")
	private Set<Genre> genres ; 
    */
	
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
	
	
	
	/*public Game(Long idgames, @NotNull @Size(min = 2, max = 32) String name,
			@Size(min = 4, max = 256) String description, int year, Set<Genre> genres) {
		super();
		this.idgames = idgames;
		this.name = name;
		this.description = description;
		this.year = year;
		this.genres = genres;
	}
*/
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
	
	/*public Set<Genre> getGenres() {
		return genres;
	}
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}*/
	@Override
	public String toString() {
		return "Game [idgames=" + idgames + ", name=" + name + ", description=" + description + ", year=" + year
				+ "]";
	}

	



	
	
	

}
