package com.movie.pojo;

import java.time.LocalDate;

public class Movie 
{
	private Integer movieId;
	private String movieName;
	private String director;
	private String producer;
	private String cast;
	private LocalDate releaseDate;
	private String lang;
	
	
	public Movie(String movieName, String director, String producer, String cast, LocalDate releaseDate, String lang) {
		super();
		this.movieName = movieName;
		this.director = director;
		this.producer = producer;
		this.cast = cast;
		this.releaseDate = releaseDate;
		this.lang = lang;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(Integer movieId, String movieName, String director, String producer, String cast,
			LocalDate releaseDate, String lang) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.director = director;
		this.producer = producer;
		this.cast = cast;
		this.releaseDate = releaseDate;
		this.lang = lang;
	}


	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public LocalDate getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getlang() {
		return lang;
	}
	public void setlang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "Movie \n[\nmovieId = " + movieId + ", \nmovieName = " + movieName + ", \ndirector = " + director + ", \nproducer = "
				+ producer + ", \ncast = " + cast + ", \nreleaseDate = " + releaseDate + ", \nlang = " + lang + "\n]";
	}
	
	

}
