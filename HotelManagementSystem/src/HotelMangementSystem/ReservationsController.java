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
	    
	    Guest guest = guests.get(guestId);
	    Room room = RoomController.getRoomById(roomId, rooms);
	    if(room.isReserved(arrivalDate, departureDate)) {
	    	System.out.println("This room is reserved!");
	    	return;
	    }else {
	    	int days = Period.between(arrivalDate, departureDate).getDays();
	    	double sum = days*room.getPrice(); 
	    	double total = sum - sum*guest.getDiscount();
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
	    	Reservation r = new Reservation(arrivalDate, departureDate, total,status, guest, room);
	    	r.print();
	    	reservations.add(r);
	    	System.out.println();
	    }
	}

}
