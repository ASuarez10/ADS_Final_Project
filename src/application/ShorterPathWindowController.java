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
import javafx.scene.shape.Line;
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
    
    public void opacity0() {
		Genova.setOpacity(0);
		Pijao.setOpacity(0);
		Buenavista.setOpacity(0);
		Cordoba.setOpacity(0);
		LaTebaida.setOpacity(0);
		Calarca.setOpacity(0);
		Montenegro.setOpacity(0);
		Quimbaya.setOpacity(0);
		Filandia.setOpacity(0);
		Salento.setOpacity(0);
		Armenia.setOpacity(0);
		genova_Pijao.setOpacity(0);
		genova_Buenavista.setOpacity(0);
		pijao_Cordoba.setOpacity(0);
		buenavista_Cordoba.setOpacity(0);
		cordoba_Calarca.setOpacity(0);
		calarca_Montenegro.setOpacity(0);
		calarca_LaTebaida.setOpacity(0);
		laTebaida_Montenegro.setOpacity(0);
		montenegro_Quimbaya.setOpacity(0);
		quimbaya_Filandia.setOpacity(0);
		filandia_Salento.setOpacity(0);
		armenia_Salento.setOpacity(0);
	}
    
    @FXML private Line genova_Pijao;
	@FXML private Line genova_Buenavista;
	@FXML private Line pijao_Cordoba;
	@FXML private Line buenavista_Cordoba;
	@FXML private Line cordoba_Calarca;
	@FXML private Line calarca_Montenegro;
	@FXML private Line calarca_LaTebaida;
	@FXML private Line laTebaida_Montenegro;
	@FXML private Line montenegro_Quimbaya;
	@FXML private Line quimbaya_Filandia;
	@FXML private Line filandia_Salento;
	@FXML private Line armenia_Salento;
	
	@FXML
	void getID(MouseEvent e) {
		
		
		if(origin == null) {		
			origin = ((Circle)e.getSource()).getId();
			((Circle)e.getSource()).setOpacity(1);
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
			((Circle)e.getSource()).setOpacity(1);
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
			confirmation.setContentText("¿Estás seguro de que quieres borrar los datos?");
			confirmation.setTitle("Clear");
			
			Optional<ButtonType> result = confirmation.showAndWait();
			if(result.isPresent() && result.get() == ButtonType.OK) {
				origin = null;
				destination = null;
				originLabel.setText("Origin:");
				destinationLabel.setText("Destination:");
				opacity0();
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
