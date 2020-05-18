package application;

import java.util.ArrayList;
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
import model.AdjacencyMatrix;
import model.GraphAlgorithms;
import model.IGraph;
import model.*;

public class FullPathWindowController {
	
	private IGraph<String> graph;
	private GraphAlgorithms solution;
	
	private  ArrayList<String> namesPlace;
	private String[][] costs;

	@FXML
	private Label originLabel;
	
	@FXML
	private Label resultsLabel;
	
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
				resultsLabel.setText("");
				opacity0();
			}
		}
	}
	
	@FXML
	void matrixButton(Event e) {
		solution = new GraphAlgorithms<Object>();
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No ha datos suficientes, por favor elige el origen y el destino");
			noData.setTitle("Datos insuficientes");
			noData.show();
		}else {
			graph = new AdjacencyMatrix<String>();
			int index = 0;
			for (int i = 0; i < namesPlace.size(); i++) {
				if(namesPlace.get(i).equals(origin)) {
					index = i;
					//Prueba
					System.out.println("Origin: "+ namesPlace.get(i));
				}
			}
			for (int i = index; i < namesPlace.size(); i++) {
				//Prueba
				String a = namesPlace.get(i);
				graph.addVertex(a);
				System.out.println("Añadiendo al grafo: "+ namesPlace.get(i));
			}
			for (int i = index; i < namesPlace.size(); i++) {
				for (int j = 0; j < costs.length; j++) {
					if(namesPlace.get(i).equals(costs[j][0])) {
						String b = costs[j][0];
						String c = costs[j][1];
						String d = costs[j][2];
						try {
							
							int z = Integer.parseInt(d);
							graph.addEdge(b, c, z);
							//Prueba
							System.out.println("Agregando arista: " + b + " " + c + " " + z);
						}catch(Exception a) {
							System.out.println("Error" + b + " " + c);
						}
					
					}
				}
			}
			GraphAlgorithms.dijkstra(origin, graph, 0);
			String result = "Result: \n" + " " ;
			double ab = 0;
			for (int i = 0; i < GraphAlgorithms.getCost().length; i++) {
				ab += GraphAlgorithms.getCost()[i];
			}
			result += ab;
			resultsLabel.setText("The Algorithm dijkstra with matrix adjacency throws" +result + " like a minimum height" + "\n");
			
			//System.out.println(solution.getVertex());
			
		}
		
	}
	
	@FXML
	void listButton(Event e) {
		solution = new GraphAlgorithms<Object>();
		if(origin == null) {
			Alert noData = new Alert(AlertType.ERROR);
			noData.setContentText("No ha datos suficientes, por favor elige el origen y el destino");
			noData.setTitle("Datos insuficientes");
			noData.show();
		}else {
			graph = new AdjacencyList<String>();
			int index = 0;
			for (int i = 0; i < namesPlace.size(); i++) {
				if(namesPlace.get(i).equals(origin)) {
					index = i;
					//Prueba
					System.out.println("Origin: "+ namesPlace.get(i));
				}
			}
			for (int i = index; i < namesPlace.size(); i++) {
				//Prueba
				String a = namesPlace.get(i);
				graph.addVertex(a);
				System.out.println("Añadiendo al grafo: "+ namesPlace.get(i));
			}
			for (int i = index; i < namesPlace.size(); i++) {
				for (int j = 0; j < costs.length; j++) {
					if(namesPlace.get(i).equals(costs[j][0])) {
						String b = costs[j][0];
						String c = costs[j][1];
						String d = costs[j][2];
						try {
							
							int z = Integer.parseInt(d);
							graph.addEdge(b, c, z);
							//Prueba
							System.out.println("Agregando arista: " + b + " " + c + " " + z);
						}catch(Exception a) {
							System.out.println("Error" + b + " " + c);
						}
					
					}
				}
			}
			GraphAlgorithms.dijkstra(origin, graph, 0);
			String result = "Result: \n" + " " ;
			double ab = 0;
			for (int i = 0; i < GraphAlgorithms.getCost().length; i++) {
				ab += GraphAlgorithms.getCost()[i];
			}
			result += ab;
			resultsLabel.setText("The Algorithm dijkstra with list adjacency throws" +result + " like a minimum height" + "\n");
			
			//System.out.println(solution.getVertex());
			
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
