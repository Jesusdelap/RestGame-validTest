package com.rest.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rest.demo.enums.GenreEnum;

@Entity
@Table(name="genres")
public class Genre implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idgenres;
	
    @Enumerated(value = EnumType.STRING)
    @Column(name = "enum")
	private GenreEnum genreEnum;
    
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "genres")
    private List<Game> games = new ArrayList<>();
    
	public Genre(Long idgenres, GenreEnum genreEnum, List<Game> games) {
		super();
		this.idgenres = idgenres;
		this.genreEnum = genreEnum;
		this.games = games;
	}

	public Genre() {
		super();
	}

	public Long getIdgenres() {
		return idgenres;
	}

	public void setIdgenres(Long idgenres) {
		this.idgenres = idgenres;
	}

	public GenreEnum getGenreEnum() {
		return genreEnum;
	}

	public void setGenreEnum(GenreEnum genreEnum) {
		this.genreEnum = genreEnum;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Genre [idgenres=" + idgenres + ", genreEnum= " + genreEnum +" ]";
	}




	
	
	
	
	

}
