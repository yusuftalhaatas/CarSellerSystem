package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.*;

public class UpdateVehiclePageController {
    @FXML
    private TextField plateNumberTextField;

    @FXML
    private TextField newPriceTextField;

    @FXML
    private Button updateButton;

    @FXML
    private Label notFoundLabel;

    @FXML
    private void initialize() {
        updateButton.setOnAction(event -> updateVehiclePrice());
    }

    private void updateVehiclePrice() {
        String plateNumber = plateNumberTextField.getText();
        String newPrice = newPriceTextField.getText();
        boolean found = false;

        try {
            File file = new File("vehicles.txt");
            File tempFile = new File("temp.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(tempFile, true);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String filePlateNumber = parts[0].trim();

                if (filePlateNumber.equals(plateNumber)) {
                    found = true;
                    String updatedLine = plateNumber + "," +parts[1]+ "," +parts[2]+ ","+parts[3]+ ","+parts[4]+ ","+newPrice;
                    fileWriter.write(updatedLine + System.lineSeparator());
                } else {
                    fileWriter.write(line + System.lineSeparator());
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

        if (found) {
            notFoundLabel.setVisible(false);
        } else {
            notFoundLabel.setVisible(true);
        }
    }
}
