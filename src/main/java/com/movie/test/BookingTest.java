package com.movie.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.movie.dao.BookingDaoImpl;
import com.movie.dao.CustomerDaoImpl;
import com.movie.dao.LoginDaoImpl;
import com.movie.dao.ShowDaoImpl;
import com.movie.pojo.Booking;
import com.movie.pojo.Customer;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

public class BookingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		LoginDaoImpl limpl=new LoginDaoImpl();
		boolean flag, exit=false;
		Booking b=null;
		BookingDaoImpl bimpl=new BookingDaoImpl();
		List<Booking> blist=null;
		ShowDaoImpl simpl = new ShowDaoImpl();
		List<Show> slist=null;
		int option;
		

		Integer bookId;
		Integer showId;
		Show s;
		LocalDateTime bookingDate;
		String email="";
		String seats="";
		Double totalBill;

		while(true) {

			System.out.println("Enter username (Email id) : ");
			String userName=sc.nextLine();

			System.out.println("Enter password: ");
			String password=sc.nextLine();

			flag=limpl.checkAdmin(userName, password);
			if(flag) {
				System.out.println("you have logged in as ADMIN ");

				do {
					System.out.println("Enter 1----> SEARCH BOOKING BY ID");
					System.out.println("Enter 2----> SHOW ALL BOOKING");
					System.out.println("enter 3----> E X I T");

					option = sc.nextInt();sc.nextLine();

					switch(option) {
					case 1:
						System.out.println("Enter Booking Id");
						bookId=sc.nextInt();
						sc.nextLine();
						
						b=bimpl.searchBookingById(bookId);
						if(b!=null) {
							
							System.out.println("*****YOUR SEARCH RESULT******");
							System.out.println(b);
						}
						else
							System.err.println("NO data found with this id....");
						break;
						
					case 2 :
						blist=bimpl.showAllBookings();
						if(blist!=null) {
							for(Booking b1:blist) {
								System.out.println("Show Date : " + b1.getS().getShowDate());
								System.out.println("Timing : " + b1.getS().getStartTime() + " To " + b1.getS().getEndTime());
								System.out.println("Email : " + b1.getEmail());
								System.out.println("Seats : " + b1.getSeats());
								System.out.println("Total Bill : " + b1.getTotalBill());
								System.out.println("----------------------------------------------------");
							}
						}
						break;
						
					case 3 :
						System.out.println("THANK YOU VISIT SOON......");
						exit=true;
						System.exit(0);
						break;
						

					default: System.err.println("Invailid input. please give numbers from options only!!!!");
					}
				}
				while(exit==false);

			}
			else {
				flag=limpl.checkCustomer(userName, password);
				if(flag) {
					Customer c = new CustomerDaoImpl().searchCustomerByEmail(userName);
					System.out.println("WELCOME TO OUR WEBSITE " + c.getCname());
					
					do {
						System.out.println("Enter 1----> BOOK MY SHOW");
						System.out.println("Enter 2----> CANCLE MY BOOKING");
						System.out.println("Enter 3----> DISPLAY MY BOOKING HISTORY");
						System.out.println("enter 4----> E X I T");
						
						option=sc.nextInt();
						sc.nextLine();
						switch(option) {
						
						case 1 :
							slist=simpl.fetchAllShow();
							for(Show s1 : slist) {
								System.out.println("Show Id : " + s1.getShowId());
								Movie m = s1.getM();
								System.out.println("MOvie Name : " + m.getMovieName());
								System.out.println("Movie Cast : " + m.getCast());
								System.out.println("Theatre Location : " + s1.getTheatre_Location());
								System.out.println("Show Date : " +s1.getShowDate());
								System.out.println("Timing : " + s1.getStartTime() + " To " + s1.getEndTime());
								System.out.println("Price : " + s1.getTicketPrice());
								System.out.println("--------------------------------------------");
							}
							System.out.println("ENter Show Id : ");
							showId=sc.nextInt();
							sc.nextLine();
							
							
							email=userName;
							
							System.out.println("Enter the no.  of seats to be booked : ");
							int noOfSeats=sc.nextInt();
							sc.nextLine();
							for(int i=1; i<=noOfSeats; i++) {
								System.out.print("Enter seat name : ");
								if(i==noOfSeats)
									seats+=sc.next();
								else 
									seats+=sc.next()+", ";
							}
							sc.nextLine();
							/*
							 * s=simpl.searchShowById(showId); 
							 * double ticketPrice=s.getTicketPrice();
							 * totalBill=noOfSeats*ticketPrice;
							 */
							totalBill=noOfSeats*(simpl.searchShowById(showId).getTicketPrice());
							
							b=new Booking();
							/* b.setBookingDate(LocalDateTime.parse(date)); */
							b.setEmail(email);
							b.setSeats(seats);
							b.setShowId(showId);
							b.setTotalBill(totalBill);
							Booking b1=bimpl.bookMyShow(b);
							
							if(b1!=null) {
								System.out.println("----- YOUR SHOW HAS BEEN BOOKED SUCCESSEFULLY ----");
								System.out.println("HAVE FUN.....");
								System.out.println("BOOKING ID : "+b1.getBookingId());
								System.out.println("MOVIE NAME: "+b1.getS().getM().getMovieName());
								System.out.println("DATE : "+b1.getS().getShowDate());
								System.out.println("THEATRE NAME : "+b1.getS().getTheatre_Location());
								System.out.println("SCREEN : "+b1.getS().getScreenName());
								System.out.println("TIMINGS : "+b1.getS().getStartTime()+" to "+b1.getS().getEndTime());
								System.out.println("SEATS : "+b1.getSeats());
								System.out.println("TOTAL BILL : "+b1.getTotalBill());
								System.out.println("STATUS : "+b1.getStatus());
								System.out.println("-------------------------------------");
							}
							else {
								System.out.println("ERROR WHILE BOOKING....Please try again");
							}
							
							break;
							
						case 2 :
							System.out.println("Enter booking id : ");
							bookId=sc.nextInt();
							sc.nextLine();
							flag=bimpl.cancelMyShow(bookId);
							if(flag) {
								System.out.println("YOUR BOOKING HAS BEEN CANCELED....");
							}
							else {
								System.out.println("ERROR WHILE CANCEL BOOKING....Please try again");
							}
							
							break;
							
						case 3 :
							email=userName;
							blist=bimpl.displayMyBookingHistory(email);
							
							if(blist!=null && !blist.isEmpty())
							{
								
								for(Booking b2 : blist) {
									System.out.println("BOOKING ID : "+b2.getBookingId());
									System.out.println("MOVIE NAME: "+b2.getS().getM().getMovieName());
									System.out.println("DATE : "+b2.getS().getShowDate());
									System.out.println("THEATRE NAME : "+b2.getS().getTheatre_Location());
									System.out.println("SCREEN : "+b2.getS().getScreenName());
									System.out.println("TIMINGS : "+b2.getS().getStartTime()+" to "+b2.getS().getEndTime());
									System.out.println("SEATS : "+b2.getSeats());
									System.out.println("TOTAL BILL : "+b2.getTotalBill());
									System.out.println("STATUS : "+b2.getStatus());
									System.out.println("-------------------------------------");
								}
							}
							break;
							
						case 4 :
							System.out.println("THANK YOU VISIT SOON......");
							System.exit(0);
							
						default : System.out.println("Please give input according to option. please try again");
						}
					}
					while(exit==false);
				}
				else {
					System.err.println("given creadentials are wrong. Please try again!!!!");
				}

			}
		}
	}

}
