package application;

import model.*;

import java.util.ArrayList;
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
	
	private IGraph<String> graph;
	
	private  ArrayList<String> namesPlace;
	private String[][] costs;

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
	void initialize() {
		namesPlace = new ArrayList<String>();
		namesPlace.add("Genova");
		namesPlace.add("Pijao");
		namesPlace.add("Buenavista");
		namesPlace.add("Cordoba");
		namesPlace.add("Calarca");
		namesPlace.add("Armenia");
		namesPlace.add("LaTebaida");
		namesPlace.add("Montenegro");
		namesPlace.add("Quimbaya");
		namesPlace.add("Filandia");
		namesPlace.add("Salento");
		
		
		costs = new String[12][3];
		
		//
		costs[0][0] = "Genova";
		costs[0][1] = "Pijao";
		costs[0][2] = "10";
		
		costs[1][0] = "Genova";
		costs[1][1] = "Buenavista";
		costs[1][2] = "14";
		
		costs[2][0] = "Pijao";
		costs[2][1] = "Cordoba";
		costs[2][2] = "12";
		
		costs[3][0] = "Buenavista";
		costs[3][1] = "Cordoba";
		costs[3][2] = "20";
		
		costs[4][0] = "Cordoba";
		costs[4][1] = "Calarca";
		costs[4][2] = "30";
		
		costs[5][0] = "Calarca";
		costs[5][1] = "Armenia";
		costs[5][2] = "10";
		
		costs[6][0] = "Armenia";
		costs[6][1] = "LaTebaida";
		costs[6][2] = "14";
		
		costs[7][0] = "Armenia";
		costs[7][1] = "Montenegro";
		costs[7][2] = "13";
		
		costs[8][0] = "LaTebaida";
		costs[8][1] = "Montenegro";
		costs[8][2] = "19";
		
		costs[9][0] = "Montenegro";
		costs[9][1] = "Quimbaya";
		costs[9][2] = "12";
		
		costs[10][0] = "Quimbaya";
		costs[10][1] = "Filandia";
		costs[10][2] = "19";
		
		costs[11][0] = "Filandia";
		costs[11][1] = "Salento";
		costs[11][2] = "12";
		
		
		
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
			confirmation.setContentText("¿Estás seguro de que quieres borrar los datos?");
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
		}else{
			System.out.println("Hello");
			graph = new AdjacencyMatrix<String>();
			graph.addVertex(origin);
			int index = 0;
			int desti = 0;
			for (int i = 0; i < namesPlace.size(); i++) {
				if(namesPlace.get(i) == origin) {
					index = i;
					//Prueba
					System.out.println("Origin: "+ namesPlace.get(i));
				}
				if(namesPlace.get(i) == destination) {
					desti = i;
					//Prueba
					System.out.println("Destination: "+ namesPlace.get(i));
				}
			}
			
			
			
			
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
