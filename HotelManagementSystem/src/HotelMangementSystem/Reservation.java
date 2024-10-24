package HotelMangementSystem;

import java.time.LocalDate;

public class Reservation {
	
	private LocalDate arrivalDate;
	private LocalDate departureDate;
	private double price;
	private String status;
	private Guest guest;
	private Room room;
	
	public Reservation(LocalDate arrivalDate, LocalDate departureDate, double price, String status, Guest guest, Room room) {
		this.arrivalDate =  arrivalDate;
		this.departureDate = departureDate;
		this.price = price;
		this .status = status;
		this.guest = guest;
		this.room = room;
	}
	public Reservation() {}
	
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

}
