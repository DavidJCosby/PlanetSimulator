package window;

import render.renderObjects.SimulationPane;

import javafx.scene.layout.*;

public class ProjectWindow extends Window {
	private BorderPane borderPane = new BorderPane();
	private SimulationPane simulationPane = new SimulationPane();
	
	public ProjectWindow() {
		super();
		setup();
	}
	
	private void setup() {
		borderPane.setCenter(simulationPane);
		getContents().getChildren().add(borderPane);
	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
}
