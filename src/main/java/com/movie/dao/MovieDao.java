package com.movie.dao;

import java.util.List;

import com.movie.pojo.Movie;

/*
 * Dao:-Data Access Object
 * */
public interface MovieDao 
{
	public boolean addMovie(Movie m);
	public boolean updateMovie(Movie m);
	public boolean deleteMovie(Integer movieId);
	
	public Movie searchMovieById(Integer movieId);
	public List<Movie> searchMovieByDirector(String director);
	public List<Movie> searchMovieByLanguage(String lang);
	public List<Movie> searchMovieByCast(String cast);
	public List<Movie> fetchallMovies();
	public Integer searchMovieId(String movieName);


}
