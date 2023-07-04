package application;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class WelcomePageController {
	   @FXML
	    private Button addVehicleButton;

	    @FXML
	    private Button deleteVehicleButton;

	    @FXML
	    private Button updateVehicleButton;

	    @FXML
	    private Button listVehicleButton;
	    @FXML
	    private void initialize() {
	    	addVehicleButton.setOnAction(event -> {
	            System.out.println("Add Vehicle button clicked");

	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddVehiclePage.fxml"));
	                Parent root = loader.load();
	                Stage addVehicleStage = new Stage();
	                addVehicleStage.setScene(new Scene(root));
	                addVehicleStage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });
	    	
	    	deleteVehicleButton.setOnAction(event -> {
	            System.out.println("Delete Vehicle button clicked");

	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteVehiclePage.fxml"));
	                Parent root = loader.load();
	                Stage deleteVehicleStage = new Stage();
	                deleteVehicleStage.setScene(new Scene(root));
	                deleteVehicleStage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });
	    	
	    	updateVehicleButton.setOnAction(event -> {
	            System.out.println("Update Vehicle button clicked");

	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("UpdateVehiclePage.fxml"));
	                Parent root = loader.load();
	                Stage updateVehicleStage = new Stage();
	                updateVehicleStage.setScene(new Scene(root));
	                updateVehicleStage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });
	    	
	    	listVehicleButton.setOnAction(event -> {
	            System.out.println("List Vehicle button clicked");

	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListVehiclePage.fxml"));
	                Parent root = loader.load();
	                Stage listVehicleStage = new Stage();
	                listVehicleStage.setScene(new Scene(root));
	                listVehicleStage.show();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        });
	    }
}
