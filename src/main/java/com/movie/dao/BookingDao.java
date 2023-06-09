package com.movie.dao;

import java.util.List;

import com.movie.pojo.Booking;

public interface BookingDao {
	
	public Booking bookMyShow(Booking b);
	public boolean cancelMyShow(Integer bookId);
	
	
	public List<Booking> displayMyBookingHistory(String email);
	public Booking searchBookingById(Integer bookId);
	
	public List<Booking> showAllBookings();
	
}
