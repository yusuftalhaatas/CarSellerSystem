package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Car extends Vehicle {
	private int doorNumber;
	
	public Car(String licensePlate, String brand, String type, int price, int year, int doorNumber) {
		super(licensePlate, brand, type, price, year);
		this.doorNumber = doorNumber;
	}
	
	public int getDoorNumber() {
		return doorNumber;
	}
	
	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}
	public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("vehicles.txt", true));
            
            String carInfo = getLicensePlate() + "," + getBrand() + "," + getYear() + "," +
                    getType() + "," + getDoorNumber() + "," + getPrice();
            
            writer.write(carInfo);
            writer.newLine();
            
            writer.close();
            System.out.println("Car information saved to file.");
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
        }
}
