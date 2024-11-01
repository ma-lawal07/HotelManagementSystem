package HotelMangementSystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationsController {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public static void createNewReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner scanner) {
		System.out.println("Enter arrival date(yyy-MM-dd): ");
		String arrDate = scanner.next();
	    System.out.println("Enter departure date (yyyy-MM-dd): ");
	    String depDate = scanner.next();
	    System.out.println("Enter guest id(int): \n-1 to earch guest by name");
	    int guestId = scanner.nextInt();
	    if(guestId == -1) {
	    	GuestsController.searchGuestByName(guests, scanner);
	    	System.out.println("Enter guest id (int): ");
	    	guestId = scanner.nextInt();
	    }
	    System.out.println("Enter room id(Int): \n-1 to show all rooms");
	    int roomId = scanner.nextInt();
	    if(roomId == -1) {
	    	RoomController.showAllRooms(rooms);
	    	System.out.println("Enter room id(Int): ");
	    	roomId = scanner.nextInt();
	    }
	    
	    LocalDate arrivalDate = LocalDate.parse(arrDate,formatter);
	    LocalDate departureDate = LocalDate.parse(depDate, formatter);
	    
	    Guest guest = reservation.getGuest();
	    
	    
	    Room room = RoomController.getRoomById(roomId, rooms);
	    if(room.isReserved(arrivalDate, departureDate)) {
	    	System.out.println("This room is reserved!");
	    	return;
	    }else {
	    	int days = Period.between(arrivalDate, departureDate).getDays();
	    	double sum = days*room.getPrice(); 
	    	double total = sum - sum*guest.getDiscount()/100;
	    	System.out.println("Total before discount = " + sum);
	    	System.out.println("Total after discount =" + total);
	    	System.out.println("Will you pay now?\n1.Yes\n2. No");
	    	int j = scanner.nextInt();
	    	String status;
	    	if (j==1) {
	    		status = "Paid";
	    	} else {
	    		status = "reserved";
	    	}
	    	reservation.setArrivalDate(arrivalDate);
	    	reservation.setArrivalDate(departureDate);
	    	reservation.setRoom(room);
	    	reservation.set
	  //  	Reservation r = new Reservation(arrivalDate, departureDate, total,status, guest, room);
	//    	reservations.add(r);
	    	r.print();
	    	System.out.println();
	    }
	}
	public static void showAllReservations(ArrayList<Reservation> reservations, Scanner scanner) {
		for(Reservation r: reservations) {
			System.out.println("\n-----------------------------");
			System.out.println("id: "+reservations.indexOf(r));
			System.out.println("Arrival Date: "+ r.getArrivalDatetoString());
			System.out.println("Departure Date: " + r.getDepartureDatetoString());
			System.out.println("Guest Name: " + r.getGuest().getName());
			System.out.println("Room id: " + r.getRoom().getId());
			System.out.println("Price: " + r.getPrice());
			System.out.println("Status: "+ r.getStatus());
			System.out.println("-------------------------------");
		}
	}
	public static void getReservationbyGuestName(ArrayList<Reservation> reservations, Scanner scanner) {
		System.out.println("Enter guest name: ");
		String guestName = scanner.next();
		for (Reservation r: reservations) {
			String name = r.getGuest().getName();
			if(guestName.equals(name)) r.print();
		}
	}
	public static void getReservationbyGuestId(ArrayList<Reservation> reservations, Scanner scanner) {
		System.out.println("Enter guest id(int): ");
		int guestId = scanner.nextInt();
		for (Reservation r: reservations) {
			int id = r.getGuest().getId();
			if(guestId == id) r.print();
		}
	}
	public static void editReservtion(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner scanner) {
		System.out.println("Enter reservation id (int): \n-1 to show all reservation ids");
		int id = scanner.nextInt();
		if(id == -1) {
			showAllReservations(reservations, scanner);
			System.out.println("Enter reservation id (int): ");
		}
		Reservation reservation = reservations.get(id);
		System.out.println("Enter arrival date(yyy-MM-dd): \n-1 to keep it");
		String arrDate = scanner.next();
		if(arrDate.equals("-1")) {
			arrDate = reservation.getArrivalDatetoString();
		}
		System.out.println("Enter departure date(yyy-MM-dd): \n-1 to keep it");
		String depDate = scanner.next();
		if(depDate.equals("-1")) {
			arrDate = reservation.getDepartureDatetoString();
		}
		
		System.out.println("Enter room id (int): \n-1 to keep it\n-2 to show all rooms");
		int roomId = scanner.nextInt();
		if(roomId ==-1) {
			roomId = reservation.getRoom().getId(); 
		} else if (roomId==2) {
			RoomController.showAllRooms(rooms);
			System.out.println("Enter room id (int): ");
			roomId = scanner.nextInt();
		}
	}

}
