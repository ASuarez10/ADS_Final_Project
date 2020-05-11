package application;

import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FullPathWindowController {

	@FXML
	private Label originLabel;
	
	private String origin;
	
	@FXML
	void back(ActionEvent e) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			PrincipalWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@FXML
	void setOrigin(MouseEvent e) {
		
		if(origin == null) {
			origin = ((Circle)e.getSource()).getId();
			originLabel.setText("Origin: " + origin);
		}
		
	}
	
	@FXML
	void clear(Event e) {
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No hay datos para borrar");
			noData.setTitle("Clear");
			noData.show();
		}else {
			Alert confirmation = new Alert(AlertType.CONFIRMATION);
			confirmation.setContentText("¿Estás seguro de que quieres borrar los datos?");
			confirmation.setTitle("Clear");
			
			Optional<ButtonType> result = confirmation.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.OK) {
				origin = null;
				originLabel.setText("Origin:");
			}
		}
	}
	
	@FXML
	void matrixButton(Event e) {
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No hay datos suficientes. Por favor elige el lugar de origen");
			noData.setTitle("Datos insufientes");
			noData.show();
		}else{
			
		}
	}
	
	@FXML
	void listButton(Event e) {
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No hay datos suficientes. Por favor elige el lugar de origen");
			noData.setTitle("Datos insufientes");
			noData.show();
		}else{
			
		}
	}
	
}//end
