package com.movie.dao;

import java.time.LocalTime;
import java.util.List;

import com.movie.pojo.Show;

public interface ShowDao {
	
	public boolean addShow(Show s);
	public boolean updateShow(Show s);
	public boolean deleteShow(Integer showId);
	
	public List<Show> searchShowByTheatre(String theatre_Location);
	public List<Show> searchShowByTime(LocalTime startTime);
	public List<Show> searchShowByMovie(String movieName);
	public List<Show> fetchAllShow();
	public Show searchShowById(Integer showId);
	public boolean deleteShowOfMovie(Integer movieId);
}
