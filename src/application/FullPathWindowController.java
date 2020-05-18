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
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class FullPathWindowController {

	@FXML
	private Label originLabel;
	
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
			((Circle)e.getSource()).setOpacity(1);
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
				opacity0();
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
	
}//end
