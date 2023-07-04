package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bus extends Vehicle {
	private int capacity;
	
	public Bus(String licensePlate, String brand, String type, int price, int year, int capacity) {
		super(licensePlate, brand, type, price, year);
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt", true));
            
            String carInfo = getLicensePlate() + "," + getBrand() + "," + getYear() + "," +
                    getType() + "," + getCapacity() + "," + getPrice();
            
            writer.write(carInfo);
            writer.newLine();
            
            writer.close();
            System.out.println("Bus information saved to file.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
        }
}
