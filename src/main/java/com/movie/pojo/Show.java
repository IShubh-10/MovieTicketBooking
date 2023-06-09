package com.movie.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {

	private Integer showId;
	private Integer movieId;
	private Movie m;
	private String theatre_Location;
	private String screenName;
	private LocalDate showDate;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double ticketPrice;


	public Show() {
		super();
	}

	public Show(Integer movieId, Movie m, String theatre_Location, String screenName, LocalDate showDate,
			LocalTime startTime, LocalTime endTime, Double ticketPrice) {
		super();
		this.movieId = movieId;
		this.m = m;
		this.theatre_Location = theatre_Location;
		this.screenName = screenName;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
	}

	public Show(Integer showId, Integer movieId, Movie m, String theatre_Location, String screenName,
			LocalDate showDate, LocalTime startTime, LocalTime endTime, Double ticketPrice) {
		super();
		this.showId = showId;
		this.movieId = movieId;
		this.m = m;
		this.theatre_Location = theatre_Location;
		this.screenName = screenName;
		this.showDate = showDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ticketPrice = ticketPrice;
	}

	public Integer getShowId() {
		return showId;
	}
	public void setShowId(Integer showId) {
		this.showId = showId;
	}
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public Movie getM() {
		return m;
	}
	public void setM(Movie m) {
		this.m = m;
	}
	public String getTheatre_Location() {
		return theatre_Location;
	}
	public void setTheatre_Location(String theatre_Location) {
		this.theatre_Location = theatre_Location;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public LocalDate getShowDate() {
		return showDate;
	}
	public void setShowDate(LocalDate showDate) {
		this.showDate = showDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public Double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "SHOW \nshowId = " + showId + "\nmovieId = " + movieId + "\nm = " + m + "\ntheatre_Location = " + theatre_Location
				+ "\nscreenName = " + screenName + "\nshowDate = " + showDate + "\nstartTime = " + startTime + "\nendTime = "
				+ endTime + "\nticketPrice = " + ticketPrice ;
	}

}
