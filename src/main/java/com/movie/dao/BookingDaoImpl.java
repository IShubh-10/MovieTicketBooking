package com.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.movie.pojo.Booking;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;
import com.movie.utility.DBConnection;

public class BookingDaoImpl implements BookingDao {

	Connection con=null;
	PreparedStatement ps=null;
	String sql=null;
	ResultSet rs=null;

	Booking b=null;
	List<Booking> blist=null;

	@Override
	public Booking bookMyShow(Booking b) {

		con=DBConnection.makeConnection();
		sql="insert into Booking(showId, bookingDate, email, seats, totalBill, status) values(?,?,?,?,?,?)";

			try {
				/* Statement.RETURN_GENERATED_KEYS is final variable in statement object
				 * which stores the primary key generated in the table for the above insert query
				 * */
				
				ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setInt(1, b.getShowId());
				LocalDateTime today=LocalDateTime.now();
				DateTimeFormatter pattern= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String date=today.format(pattern);
				ps.setTimestamp(2, Timestamp.valueOf(date));
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getSeats());
				ps.setDouble(5, b.getTotalBill());
				ps.setString(6, "Confirmed");
				
				int i=ps.executeUpdate();
				if(i>0) {
					/* if the insert query is successfully executed then we need to fetch the primary key 
					 * from the RETURN_GENERATED_KEYS variable.
					 * This is done by calling getGeneratedKeys() method.
					 * */
					
					rs=ps.getGeneratedKeys();
					if(rs.next()) {
						int bookId = rs.getInt(1);        /* storing the primary key in variable bookId*/
						b=searchBookingById(bookId);      /*fetching booking object for this id*/
						return b;
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean cancelMyShow(Integer bookId) {

		con=DBConnection.makeConnection();
		sql="update Booking set status='Cancelled' where bookId=?";

		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);
			int i=ps.executeUpdate();
			if(i>0) {

				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Booking> displayMyBookingHistory(String email) {

		con=DBConnection.makeConnection();
		sql="select*from Booking where email=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			blist=new ArrayList<>();


			while(rs.next()) {
				b=new Booking();
				b.setBookingId(rs.getInt(1));

				b.setBookingDate(rs.getTimestamp(3).toLocalDateTime());
				b.setEmail(rs.getString(4));

				Show s=new ShowDaoImpl().searchShowById(rs.getInt(2));
				b.setS(s);

				b.setShowId(rs.getInt(2));
				b.setTotalBill(rs.getDouble(6));
				b.setSeats(rs.getString(5));
				b.setStatus(rs.getString(7));
				
				blist.add(b);

			}
			return blist;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}

	@Override
	public Booking searchBookingById(Integer bookId) {
		// TODO Auto-generated method stub
		con=DBConnection.makeConnection();
		sql="select * from Booking where bookId=?";

		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);

			rs=ps.executeQuery();
			if(rs.next()) {
				b=new Booking();
				b.setBookingId(rs.getInt(1));

				b.setBookingDate(rs.getTimestamp(3).toLocalDateTime());
				b.setEmail(rs.getString(4));

				Show s=new ShowDaoImpl().searchShowById(rs.getInt(2));
				b.setS(s);

				b.setShowId(rs.getInt(2));
				b.setTotalBill(rs.getDouble(6));
				b.setSeats(rs.getString(5));
				b.setStatus(rs.getString(7));

				return b;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Booking> showAllBookings() {
		// TODO Auto-generated method stub
		con=DBConnection.makeConnection();
		sql="select * from Booking";

		try {
			ps=con.prepareStatement(sql);

			rs=ps.executeQuery();
			blist=new ArrayList<>();


			while(rs.next()) {
				b=new Booking();
				b.setBookingId(rs.getInt(1));

				b.setBookingDate(rs.getTimestamp(3).toLocalDateTime());
				b.setEmail(rs.getString(4));

				Show s=new ShowDaoImpl().searchShowById(rs.getInt(2));
				b.setS(s);

				b.setShowId(rs.getInt(2));
				b.setTotalBill(rs.getDouble(6));
				b.setSeats(rs.getString(5));
				b.setStatus(rs.getString(7));
				
				blist.add(b);

			}
			return blist;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public List<String> getReservedSeats(Integer showId) {
		List<String> reservedSeats=new ArrayList<>();
		con=DBConnection.makeConnection();
		sql="select seats from booking where showId=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, showId);
			rs=ps.executeQuery();
			while(rs.next()) {
				String seats=rs.getString(1);
				String []arr=seats.split(",");
				for(String x:arr) {
					reservedSeats.add(x);
				}
			}
			return reservedSeats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void changeStatus(Integer bookId, LocalDate showDate) {
		LocalDate today=LocalDate.now();
		Period p=Period.between(today, showDate);
		int days=p.getDays();
		
		
		if(days<0) {
			sql="update booking set status='Screening done' where bookId=? && status!='Cancelled'";
			try {
				ps=con.prepareStatement(sql);
				ps.setInt(1, bookId);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

