package application;

public abstract class Vehicle {
	private String licensePlate;
	private String brand;
	private String type;
	private int price;
	private int year;
	
	public Vehicle(String licensePlate, String brand, String type, int price, int year) {
		this.licensePlate = licensePlate;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
