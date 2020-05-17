package application;

import java.util.Optional;

import javafx.event.EventHandler;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ShorterPathWindowController {

	@FXML
	private Label originLabel;
	
	@FXML
	private Label destinationLabel;
	
	private String origin;
	private String destination;
	
	@FXML
    private Circle Genova;

    @FXML
    private Circle Pijao;

    @FXML
    private Circle Buenavista;

    @FXML
    private Circle Cordoba;

    @FXML
    private Circle LaTebaida;

    @FXML
    private Circle Calarca;

    @FXML
    private Circle Montenegro;

    @FXML
    private Circle Quimbaya;

    @FXML
    private Circle Filandia;

    @FXML
    private Circle Salento;

    @FXML
    private Circle Armenia;
	
	@FXML
	void getID(MouseEvent e) {
		
		
		if(origin == null) {		
			origin = ((Circle)e.getSource()).getId();
			originLabel.setText("Origin: " + origin);
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
			if(destination == null) {
				destinationLabel.setText("Destination:");
			}else {
			destinationLabel.setText("Destination: " + destination);
			System.out.println("Destination = " + destination);
			}
		}
	}
	
	@FXML
	void start() {
		
	}
	
	@FXML
	void clear(Event e) {
		
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No ha datos suficientes, por favor elige el origen y el destino");
			noData.setTitle("Datos insuficientes");
			noData.show();
		}else {
		
			Alert confirmation = new Alert(AlertType.CONFIRMATION);
			confirmation.setContentText("�Est�s seguro de que quieres borrar los datos?");
			confirmation.setTitle("Clear");
			
			Optional<ButtonType> result = confirmation.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.OK) {
				origin = null;
				destination = null;
				originLabel.setText("Origin:");
				destinationLabel.setText("Destination:");
			}
		}
	}
	
	@FXML
	void matrixButton(Event e) {
		if(origin == destination || destination == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No ha datos suficientes, por favor elige el origen y el destino");
			noData.setTitle("Datos insuficientes");
			noData.show();
		}else {
			
		}
	}
	
	@FXML
	void listButton(Event e) {
		if(origin == destination || destination == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No ha datos suficientes, por favor elige el origen y el destino");
			noData.setTitle("Datos insuficientes");
			noData.show();
		}else {
			
		}
	}
	
	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PrincipalWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			PrincipalWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}//end
