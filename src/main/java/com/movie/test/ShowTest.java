package com.movie.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.movie.dao.LoginDaoImpl;
import com.movie.dao.ShowDaoImpl;
import com.movie.pojo.Movie;
import com.movie.pojo.Show;

public class ShowTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		LoginDaoImpl limpl = new LoginDaoImpl();
		ShowDaoImpl simpl = new ShowDaoImpl();
		Show s = null;
		boolean flag;
		List<Show> slist=null;

		Integer showId;
		Integer movieId;
		Movie m;
		String theatre_Location;
		String screenName;
		LocalDate showDate;
		LocalTime startTime;
		LocalTime endTime;
		Double ticketPrice;

		int day, month, year, hours, mins;

		System.out.println("ENTER USERNAME (E-MAIL ID) :- ");
		String userName = sc.nextLine();
		System.out.println("ENTER PASSWORD :- ");
		String password = sc.nextLine();

		flag=limpl.checkAdmin(userName, password);
		if(flag) {
			System.out.println("You've logged in as ADMIN");
			System.out.println("\n\n---- YOUR ADDED SHOW'S DOWN BELOW ----");
			slist=simpl.fetchAllShow();
			if(slist!=null && slist.isEmpty()!=true) {
				for(Show s1:slist) {
					System.out.println(s1);
					System.out.println("------------------------------------");
				}
				while(true) {
					System.out.println("\nEnter the number given in options...");
					System.out.println("Enter 1---> Add New Show");
					System.out.println("Enter 2---> Update Show");
					System.out.println("Enter 3---> Delete Show");
					System.out.println("Enter 4---> Display all Show's");
					System.out.println("Enter 5---> E X I T");

					int choice=sc.nextInt();
					switch(choice) {
					case 1 :
						HashMap<Integer, String> hm=simpl.searchMovieId();
						System.out.println("\n\n---- FORM BELOW MOVIE'S YOU CAN ADD ANY ONE TO YOUR SHOW ----");
						Set<Map.Entry<Integer, String>> pairs=hm.entrySet();
						for(Map.Entry<Integer, String> p:pairs) {
							System.out.println("\nMovie Id :"+p.getKey()+"\nMovie Name :"+p.getValue());
						}
						System.out.println("\nTO ADD SHOW FOLLOW THE PROCESS : ");
						System.out.println("Enter Movie Id : ");
						movieId=sc.nextInt();
						sc.nextLine();

						System.out.println("Enter Theatre Name : ");
						theatre_Location=sc.nextLine();

						System.out.println("Enter Screen Name : ");
						screenName=sc.nextLine();

						System.out.print("Enter day of show. Number between 1 to 31 only: ");
						day=sc.nextInt();
						sc.nextLine();

						System.out.print("Enter month of show. Number between 1 to 12 only: ");
						month=sc.nextInt();
						sc.nextLine();

						System.out.print("Enter year of show: ");
						year=sc.nextInt();
						sc.nextLine();

						showDate=LocalDate.of(year, month, day);

						System.out.println("Enter the START Timimg at which movie will be started : \n HOUR :");
						hours=sc.nextInt();
						sc.nextLine();
						System.out.println("MINUTE : ");
						mins=sc.nextInt();
						sc.nextLine();
						startTime=LocalTime.of(hours, mins);

						System.out.println("Enter the END Timimg where movie will be ended : \n HOUR :");
						hours=sc.nextInt();
						sc.nextLine();
						System.out.println("MINUTE : ");
						mins=sc.nextInt();
						sc.nextLine();
						endTime=LocalTime.of(hours, mins);

						System.out.println("Enter ticket price : ");
						ticketPrice=sc.nextDouble();
						sc.nextLine();

						s=new Show();
						s.setMovieId(movieId);
						s.setTheatre_Location(theatre_Location);
						s.setScreenName(screenName);
						s.setShowDate(showDate);
						s.setStartTime(startTime);
						s.setEndTime(endTime);
						s.setTicketPrice(ticketPrice);

						flag=simpl.addShow(s);
						if(flag) {
							System.out.println("SHOW ADDED SUCCESSEFULLY....");
						}
						else {
							System.out.println("ERROR WHILE ADDING SHOW.....");
						}

						break;

					case 2 :
						System.out.println("Enter Show Id to update : ");
						showId=sc.nextInt();
						sc.nextLine();

						s=simpl.searchShowById(showId);
						if(s!=null) {
							System.out.println("------ SHOW DETAILS ------");
							System.out.println("THEATRE NAME : " + s.getTheatre_Location());
							System.out.println("SCREEN NAME : " + s.getScreenName());
							System.out.println("MOVIE : " + s.getM().getMovieName());
							System.out.println("SHOW DATE : " + s.getShowDate());
							System.out.println("TIMING FROM : " + s.getStartTime() + " TO " + s.getEndTime());
							System.out.println("TICKET PRICE : " + s.getTicketPrice());

							System.out.println("DO you want to update this ?\nAnswer in yes or no");
							String choices = sc.nextLine();

							if(choices.equalsIgnoreCase("yes")) {
								System.out.println("Enter Theatre Name : ");
								theatre_Location=sc.nextLine();

								System.out.println("Enter Screen Name : ");
								screenName=sc.nextLine();

								System.out.print("Enter day of show. Number between 1 to 31 only: ");
								day=sc.nextInt();
								sc.nextLine();

								System.out.print("Enter month of show. Number between 1 to 12 only: ");
								month=sc.nextInt();
								sc.nextLine();

								System.out.print("Enter year of show: ");
								year=sc.nextInt();
								sc.nextLine();

								showDate=LocalDate.of(year, month, day);

								System.out.println("Enter the START Timimg at which movie will be started : \n HOUR :");
								hours=sc.nextInt();
								sc.nextLine();
								System.out.println("MINUTE : ");
								mins=sc.nextInt();
								sc.nextLine();
								startTime=LocalTime.of(hours, mins);

								System.out.println("Enter the END Timimg where movie will be ended : \n HOUR :");
								hours=sc.nextInt();
								sc.nextLine();
								System.out.println("MINUTE : ");
								mins=sc.nextInt();
								sc.nextLine();
								endTime=LocalTime.of(hours, mins);

								System.out.println("Enter ticket price : ");
								ticketPrice=sc.nextDouble();
								sc.nextLine();


								s.setShowId(showId);
								s.setTheatre_Location(theatre_Location);
								s.setScreenName(screenName);
								s.setShowDate(showDate);
								s.setStartTime(startTime);
								s.setEndTime(endTime);
								s.setTicketPrice(ticketPrice);

								flag=simpl.updateShow(s);
								if(flag)
									System.out.println("SHOW UPDATED SUCCESSFULLY....");
								else
									System.out.println("ERROR WHILE UPDATING SHOW.....");
							}
							else if(choices.equalsIgnoreCase("no")){
								System.out.println("Thank you continue browsing");
							}
							else{
								System.out.println("Please give answer in yes or no only");
							}
						}
						else {
							System.out.println("NO SUCH SHOW DETAILS FOUND WITH THIS ID");
							System.out.println("Enter Show Id Again : ");
							showId=sc.nextInt();
							sc.nextLine();
							s=simpl.searchShowById(showId);
						}
						break;

					case 3 :
						System.out.println("Enter Show Id to delete: ");
						showId=sc.nextInt();
						sc.nextLine();

						s=simpl.searchShowById(showId);
						if(s!=null) {
							System.out.println("------ SHOW DETAILS ------");
							System.out.println("THEATRE NAME : " + s.getTheatre_Location());
							System.out.println("SCREEN NAME : " + s.getScreenName());
							System.out.println("MOVIE : " + s.getM().getMovieName());
							System.out.println("SHOW DATE : " + s.getShowDate());
							System.out.println("TIMING FROM : " + s.getStartTime() + "TO " + s.getEndTime());
							System.out.println("TICKET PRICE : " + s.getTicketPrice());

							System.out.println("DO you want to update this ?\nAnswer in yes or no");
							String choices = sc.nextLine();

							if(choices.equalsIgnoreCase("yes")) {

								flag=simpl.deleteShow(showId);

								if(flag)
									System.out.println("SHOW DELETED SUCCESSFULLY....");
								else
									System.out.println("ERROR WHILE DELETING SHOW.....");
							}
							else if(choices.equalsIgnoreCase("no")){
								System.out.println("Thank you continue browsing");
							}
							else{
								System.out.println("Please give answer in yes or no only");
							}
						}
						else {
							System.out.println("NO SUCH SHOW DETAILS FOUND WITH THIS ID");
							System.out.println("Enter Show Id Again : ");
							showId=sc.nextInt();
							sc.nextLine();
							s=simpl.searchShowById(showId);
						}
						break;

					case 4 :
						slist=simpl.fetchAllShow();
						if(slist!=null && slist.isEmpty()!= true) {
							for(Show s1 : slist) {
								System.out.println("------ SHOW DETAILS ------");
								System.out.println("THEATRE NAME : " + s1.getTheatre_Location());
								System.out.println("SCREEN NAME : " + s1.getScreenName());
								System.out.println("MOVIE : " + s1.getM().getMovieName());
								System.out.println("SHOW DATE : " + s1.getShowDate());
								System.out.println("TIMING FROM : " + s1.getStartTime() + " TO " + s1.getEndTime());
								System.out.println("TICKET PRICE : " + s1.getTicketPrice());
								System.out.println("--------------------------------------");
							}
						}
						break;

					case 5 :
						System.out.println("THANK YOU.  VISIST SOON.....");
						System.exit(choice);
						break;

					default :
						System.out.println("INVALID CHOICE.....\n SELECT APPROPRIATE OPTION.");
						break;
					}

				}
			}
			else
			{
				System.out.println("\nTHERE ARE NO SHOWS.  PLEASE ADD SOME FROM BELOW.....");
				HashMap<Integer, String> hm=simpl.searchMovieId();
				Set<Map.Entry<Integer, String>> pairs=hm.entrySet();
				for(Map.Entry<Integer, String> p:pairs) {
					System.out.println("\nMovie Id :"+p.getKey()+"\nMovie Name :"+p.getValue());
				}
				System.out.println("\nTO ADD SHOW FOLLOW THE PROCESS : ");
				System.out.println("Enter Movie Id : ");
				movieId=sc.nextInt();
				sc.nextLine();

				System.out.println("Enter Theatre Name : ");
				theatre_Location=sc.nextLine();

				System.out.println("Enter Screen Name : ");
				screenName=sc.nextLine();

				System.out.print("Enter day of show. Number between 1 to 31 only: ");
				day=sc.nextInt();
				sc.nextLine();

				System.out.print("Enter month of show. Number between 1 to 12 only: ");
				month=sc.nextInt();
				sc.nextLine();

				System.out.print("Enter year of show: ");
				year=sc.nextInt();
				sc.nextLine();

				showDate=LocalDate.of(year, month, day);

				System.out.println("Enter the START Timimg at which movie will be started : \n HOUR :");
				hours=sc.nextInt();
				sc.nextLine();
				System.out.println("MINUTE : ");
				mins=sc.nextInt();
				sc.nextLine();
				startTime=LocalTime.of(hours, mins);

				System.out.println("Enter the END Timimg where movie will be ended : \n HOUR :");
				hours=sc.nextInt();
				sc.nextLine();
				System.out.println("MINUTE : ");
				mins=sc.nextInt();
				sc.nextLine();
				endTime=LocalTime.of(hours, mins);

				System.out.println("Enter ticket price : ");
				ticketPrice=sc.nextDouble();
				sc.nextLine();

				s=new Show();
				s.setMovieId(movieId);
				s.setTheatre_Location(theatre_Location);
				s.setScreenName(screenName);
				s.setShowDate(showDate);
				s.setStartTime(startTime);
				s.setEndTime(endTime);
				s.setTicketPrice(ticketPrice);

				flag=simpl.addShow(s);
				if(flag) {
					System.out.println("SHOW ADDED SUCCESSEFULLY....");
				}
				else {
					System.out.println("ERROR WHILE ADDING SHOW.....");
				}
			}
		}
		else {
			flag=limpl.checkCustomer(userName, password);
			if(flag) {
				System.out.println("You've logged in as CUSTOMER");
				while(true) {
					System.out.println("\nEnter the number given in options...");
					System.out.println("\nEnter 1---> Display all Show's");
					System.out.println("Enter 2---> Search Show's by Theatre name");
					System.out.println("Enter 3---> Search Show's by Movie");
					System.out.println("Enter 4---> Search Show's by Timing");
					System.out.println("Enter 5---> E X I T");

					int choice=sc.nextInt();
					sc.nextLine();
					switch(choice) {
					case 1 :
						slist=simpl.fetchAllShow();
						if(slist!=null && slist.isEmpty()!= true) {
							for(Show s1 : slist) {
								System.out.println("\n------ SHOW DETAILS ------");
								System.out.println("THEATRE NAME : " + s1.getTheatre_Location());
								System.out.println("SCREEN NAME : " + s1.getScreenName());
								System.out.println("MOVIE : " + s1.getM().getMovieName());
								System.out.println("SHOW DATE : " + s1.getShowDate());
								System.out.println("TIMING FROM : " + s1.getStartTime() + " TO " + s1.getEndTime());
								System.out.println("TICKET PRICE : " + s1.getTicketPrice());
								System.out.println("--------------------------------------");
							}
						}
						break;
						
					case 2 :
						System.out.println("Enter Theatre Name : ");
						theatre_Location=sc.nextLine();
	
						slist=simpl.searchShowByTheatre(theatre_Location);
						
						if(slist!=null && slist.isEmpty()!= true) {
							for(Show s1 : slist) {
								System.out.println("\n------ SHOW DETAILS ------");
								System.out.println("THEATRE NAME : " + s1.getTheatre_Location());
								System.out.println("SCREEN NAME : " + s1.getScreenName());
								System.out.println("MOVIE : " + s1.getM().getMovieName());
								System.out.println("SHOW DATE : " + s1.getShowDate());
								System.out.println("TIMING FROM : " + s1.getStartTime() + " TO " + s1.getEndTime());
								System.out.println("TICKET PRICE : " + s1.getTicketPrice());
								System.out.println("--------------------------------------");
							}
						}
						else {
							System.out.println("NO SHOW's FOR THIS PARTICULAR SEARCH");
						}
						break;
						
					case 3 :
						System.out.println("Enter Movie Name : ");
						String movieName=sc.nextLine();
						
						slist=simpl.searchShowByMovie(movieName);
						if(slist!=null && slist.isEmpty()!= true) {
							for(Show s1 : slist) {
								System.out.println("\n------ SHOW DETAILS ------");
								System.out.println("THEATRE NAME : " + s1.getTheatre_Location());
								System.out.println("SCREEN NAME : " + s1.getScreenName());
								System.out.println("MOVIE : " + s1.getM().getMovieName());
								System.out.println("SHOW DATE : " + s1.getShowDate());
								System.out.println("TIMING FROM : " + s1.getStartTime() + " TO " + s1.getEndTime());
								System.out.println("TICKET PRICE : " + s1.getTicketPrice());
								System.out.println("--------------------------------------");
							}
						}
						else {
							System.out.println("NO SHOW's FOR THIS PARTICULAR SEARCH");
						}
						break;
						
					case 4 :
						System.out.println("Enter the START Timimg at which movie will be started : \n HOUR :");
						hours=sc.nextInt();
						sc.nextLine();
						System.out.println("MINUTE : ");
						mins=sc.nextInt();
						sc.nextLine();
						startTime=LocalTime.of(hours, mins);
						
						slist=simpl.searchShowByTime(startTime);
						if(slist!=null && slist.isEmpty()!= true) {
							for(Show s1 : slist) {
								System.out.println("\n------ SHOW DETAILS ------");
								System.out.println("THEATRE NAME : " + s1.getTheatre_Location());
								System.out.println("SCREEN NAME : " + s1.getScreenName());
								System.out.println("MOVIE : " + s1.getM().getMovieName());
								System.out.println("SHOW DATE : " + s1.getShowDate());
								System.out.println("TIMING FROM : " + s1.getStartTime() + " TO " + s1.getEndTime());
								System.out.println("TICKET PRICE : " + s1.getTicketPrice());
								System.out.println("--------------------------------------");
							}
						}
						else {
							System.out.println("NO SHOW's FOR THIS PARTICULAR SEARCH");
						}
						break;
						
					case 5 :
						System.out.println("THANK YOU.  VISIT SOON");
						System.exit(choice);
						break;
						
					default :
						break;
					}
				}
			}
			else {
				System.err.println("....INVALID CREDENTIALS GIVEN.... PLEASE TRY AGAIN");
			}
		}
	}

}
