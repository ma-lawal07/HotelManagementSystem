package HotelMangementSystem;

public class Guest {
	
	int id;
	String name;
	String email;
	int discount;
	
	public Guest(int id, String name, String email, int discount) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.discount = discount;
	}
	
	public Guest() {}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void print() {
		System.out.println("id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Email: " + email);
		System.out.println("discount: " + discount);
		
		
	}
	

}
