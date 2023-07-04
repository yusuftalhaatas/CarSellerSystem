package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteVehiclePageController {
    @FXML
    private TextField plateTextField;

    @FXML
    private Button deleteButton;

    @FXML
    private Label statusLabel;

    @FXML
    private void initialize() {
        // Event handler for the deleteButton
        deleteButton.setOnAction(event -> deleteVehicle());
    }

    // Method invoked when the deleteButton is clicked
    private void deleteVehicle() {
        String plate = plateTextField.getText();
        boolean deleted = false;

        try {
            // Open the vehicles.txt file
            File file = new File("vehicles.txt");
            File tempFile = new File("temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile, true);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String filePlate = parts[0].trim();

                // If the plate number in the file is not equal to the plate being deleted,
                // write the line to the temporary file
                if (!filePlate.equals(plate)) {
                    fileWriter.write(line + System.lineSeparator());
                } else {
                    // Set the deleted flag to true if the plate is found
                    deleted = true;
                }
            }

            fileReader.close();
            bufferedReader.close();
            fileWriter.close();

            // Rename the temporary file to overwrite the original file
            tempFile.renameTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the statusLabel based on whether the vehicle was deleted or not
        if (deleted) {
            statusLabel.setText("Vehicle deleted successfully.");
        } else {
            statusLabel.setText("Vehicle not found.");
        }
    }
}
