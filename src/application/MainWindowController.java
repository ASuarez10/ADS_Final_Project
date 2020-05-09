package application;

import java.util.Optional;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class MainWindowController {

	private String origin;
	private String destination;
	
	@FXML
	void getID(MouseEvent e) {
		if(origin == null) {		
			origin = ((Circle)e.getSource()).getId();
			System.out.println("Origin = " + origin);
		}else if(destination == null) {
			destination = ((Circle)e.getSource()).getId();
			if(origin.equals(destination)) {
				Alert sameOD = new Alert(AlertType.ERROR);
				sameOD.setContentText("No puedes escoger el origen como destino. Por favor escoge un destino diferente");
				sameOD.setTitle("Eleccion incorrecta");
				sameOD.show();
				destination = null;
			}
			System.out.println("Destination = " + destination);
		}
	}
	
	@FXML
	void clear(Event e) {
		Alert confirmation = new Alert(AlertType.CONFIRMATION);
		confirmation.setContentText("¿Estás seguro de que quieres borrar los datos?");
		confirmation.setTitle("Clear");
		
		Optional<ButtonType> result = confirmation.showAndWait();
		if(result.isPresent() && result.get() == ButtonType.OK) {
			origin = null;
			destination = null;
		}
//		confirmation.show();
	}
	
}//end
