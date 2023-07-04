package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddVehiclePageController {
    private String type;

    @FXML
    private TextField licensePlateTextField;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField modelYearTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField doorCapacityTextField;

    @FXML
    private Button busButton;

    @FXML
    private Button carButton;

    @FXML
    private Button addButton;

    @FXML
    private void initialize() {
        // Event handler for the carButton
        carButton.setOnAction(event -> {
            carButtonClicked();
        });

        // Event handler for the busButton
        busButton.setOnAction(event -> {
            busButtonClicked();
        });

        // Event handler for the addButton
        addButton.setOnAction(event -> {
            addVehicleButtonClicked();
        });
    }

    // Method invoked when the addButton is clicked
    private void addVehicleButtonClicked() {
        String licensePlate = licensePlateTextField.getText();
        String brand = brandTextField.getText();
        int modelYear = Integer.parseInt(modelYearTextField.getText());
        int price = Integer.parseInt(priceTextField.getText());
        int doorCapacity = Integer.parseInt(doorCapacityTextField.getText());

        if (type.equals("Car")) {
            // Creating a Car object
            Car car = new Car(licensePlate, brand, type, price, modelYear, doorCapacity);
            car.saveToFile();
        } else if (type.equals("Bus")) {
            // Creating a Bus object
            Bus bus = new Bus(licensePlate, brand, type, price, modelYear, doorCapacity);
            bus.saveToFile();
        }
    }

    // Method invoked when the carButton is clicked
    private void carButtonClicked() {
        type = "Car";
    }

    // Method invoked when the busButton is clicked
    private void busButtonClicked() {
        type = "Bus";
    }
}
