package application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrincipalWindowController {

	@FXML
	void shorterpath(ActionEvent e) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ShorterPathWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			ShorterPathWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@FXML
	void fullPath(ActionEvent e) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("FullPathWindow.fxml"));
			Parent root = (Parent) loader.load();
			root.getStylesheets().add("application.css");// CSS
			FullPathWindowController nc = loader.getController();
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}//end
