package HotelMangementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static ArrayList<Room> rooms;
	private static ArrayList<Guest> guests;
	private static ArrayList<Employee> employees;
	private static ArrayList<Reservation> reservations;
	
	public static void main(String[] args) {
		
		rooms = new ArrayList<>();
		guests = new ArrayList<>();
		employees = new ArrayList<>();
		reservations = new ArrayList<>();
		
		int i = 0;
		while (i!=16) {
		System.out.println("Welcome to Hotel Maagement System");
		System.out.println("1.Add new room");
		System.out.println("2. Show all rooms");
		System.out.println("3. Edit room");
		System.out.println("4. Add new guests");
		System.out.println("5.Show all guests");
		System.out.println("6. Search guests by name");
		System.out.println("7. Edit guests");
		System.out.println("8. Create new reservation");
		System.out.println("9. Show all reservations");
		System.out.println("10. Get reservation by guest name");
		System.out.println("11. Get reservation by id");
		System.out.println("12. Edit reservation");
		System.out.println("13. Add new Employee");
		System.out.println("14. Show all employees");
		System.out.println("15. Edit employee data");
		System.out.println("16. Quit");
		
		Scanner scanner = new Scanner(System.in);
		
		 i = scanner.nextInt();
		switch(i) {
		case 1: 
			RoomController.AddNewRoom(rooms, scanner);
			break;
		case 2:
			RoomController.showAllRooms(rooms);
			break;
		
		case 3:
			RoomController.editRoom(rooms, scanner);
			break;
		case 4:
		    GuestsController.addNewGuest(guests, scanner);
		    break;
		case 5:
		    GuestsController.showAllGuests(guests);
		    break;
		case 6: 
			GuestsController.searchGuestByName(guests, scanner);
			break;
		case 7:
			GuestsController.editGuest(guests, scanner);
			break;
		case 8:
			ReservationsController.createNewReservation(guests,rooms, reservations, scanner);
			break;
		}
		}
		
	}

}
