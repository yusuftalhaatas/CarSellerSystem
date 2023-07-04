package application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
public class ListVehiclePageController implements OperationsInterface {

	
	
	
	
	    @FXML
	    private TableView<Car> vehicleTableView;
	    
	    @FXML
	    private TableColumn<Car, String> licensePlateColumn;
	    
	    @FXML
	    private TableColumn<Car, String> brandColumn;
	    
	    @FXML
	    private TableColumn<Car, Integer> modelYearColumn;
	    
	    @FXML
	    private TableColumn<Car, Integer> doorCapacityColumn;
	    
	    @FXML
	    private TableColumn<Car, Integer> priceColumn;
	    
	    @FXML
	    private TableColumn<Car, String> typeColumn;
	    
	    @FXML
	    private Button sortButton;
	    
	    @FXML
	    private Button searchButton;
	    
	    @FXML
	    private Label avgLabel;
	    
	    @FXML
	    private Label countLabel;
	    
	    @FXML
	    private TextField searchTextField;
	    
	    @FXML
	    private Label brandLabel;
	    
	    @FXML
	    private Label modelYearLabel;
	    
	    @FXML
	    private Label doorCapacityLabel;
	    
	    @FXML
	    private Label priceLabel;
	    
	    @FXML
	    private Label typeLabel;
	
	    private ObservableList<Car> vehicleList;
	    public void initialize() {
	        vehicleList = FXCollections.observableArrayList();
	        loadFromVehicles();
	        
	        
	        licensePlateColumn.setCellValueFactory(new PropertyValueFactory<>("licensePlate"));
	        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
	        modelYearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
	        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
	        doorCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("doorNumber"));
	        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

	        vehicleTableView.setItems(vehicleList);
	        searchButton.setOnAction(event -> {
	            
	            search(searchTextField.getText()); // Perform search based on the input text
	        });
	        
	        sortButton.setOnAction(event -> {
	            sort(); 
	        });
	        
	        average();
	        
	        
	        count();
	        
	    }
	
	@Override
	public void sort() {
		// TODO Auto-generated method stub
		vehicleList.sort(Comparator.comparing(Car::getPrice)); 
        vehicleTableView.setItems(vehicleList);
		
	}

	@Override
	public void search(String licancePlate) {
		// TODO Auto-generated method stub
		try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (licancePlate.equals(parts[0])) {
                    System.out.println("Vehicle Found");
                    String brand = parts[1];
                    String year = parts[2];
                    String type = parts[3];
                    String doorCapacity = parts[4];
                    String price = parts[5];

                    brandLabel.setText("Brand: " + brand); 
                    modelYearLabel.setText("Model Year: " + year); 
                    typeLabel.setText("Type: " + type); 
                    doorCapacityLabel.setText("Door/Capacity: " + doorCapacity); 
                    priceLabel.setText("Price: " + price+"$"); 
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
		
	}

	@Override
	public int sum() {
		int sumNum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int price = Integer.parseInt(parts[5]);
                    sumNum = price + sumNum; 
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
        return sumNum;
	}

	@Override
	public void average() {
		int countVehicle = vehicleList.size();
        avgLabel.setText("Avg: " + sum() / countVehicle);
		
	}

	@Override
	public void count() {
		countLabel.setText("Count: "+vehicleList.size());
		
	}
	
	private void loadFromVehicles() {
        try (BufferedReader reader = new BufferedReader(new FileReader("vehicles.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String plateLicense = parts[0];
                    String brand = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    String type = parts[3];
                    int capacityDoor = Integer.parseInt(parts[4]);
                    int price = Integer.parseInt(parts[5]);
                    Car vehicle = new Car(plateLicense, brand, type, price, capacityDoor, year);
                    vehicleList.add(vehicle); 
                }
            }
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

}
