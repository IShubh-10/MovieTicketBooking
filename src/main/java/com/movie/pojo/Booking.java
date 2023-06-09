package com.movie.pojo;

import java.time.LocalDateTime;

public class Booking {

	private Integer bookingId;
	private Integer ShowId;
	private Show s;
	private LocalDateTime bookingDate;
	private String email;
	private String seats;
	private Double totalBill;
	private String status;
	
	
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Booking(Integer showId, Show s, LocalDateTime bookingDate, String email, String seats, Double totalBill, String status) {
		super();
		ShowId = showId;
		this.s = s;
		this.bookingDate = bookingDate;
		this.email = email;
		this.seats = seats;
		this.totalBill = totalBill;
		this.status = status;
	}


	public Booking(Integer bookingId, Integer showId, Show s, LocalDateTime bookingDate, String email, String seats,
			Double totalBill, String status) {
		super();
		this.bookingId = bookingId;
		ShowId = showId;
		this.s = s;
		this.bookingDate = bookingDate;
		this.email = email;
		this.seats = seats;
		this.totalBill = totalBill;
		this.status = status;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Integer getShowId() {
		return ShowId;
	}

	public void setShowId(Integer showId) {
		ShowId = showId;
	}

	public Show getS() {
		return s;
	}

	public void setS(Show s) {
		this.s = s;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking \nbookingId = " + bookingId + "\nShowId = " + ShowId + "\ns = " + s + "\nbookingDate = " + bookingDate
				+ "\nemail = " + email + "\nseats = " + seats + "\ntotalBill = " + totalBill + "status = " + status;
	}
	
}
