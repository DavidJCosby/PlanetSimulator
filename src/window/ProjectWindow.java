package window;

import bridge.Bridge;

import javafx.scene.layout.*;
import planets.render.renderObjects.SimulationPane;

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
		Bridge.getRenderer().setSimulationPane(simulationPane);
		borderPane.prefWidthProperty().bind(this.widthProperty());
		borderPane.prefHeightProperty().bind(this.heightProperty());

	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
	
}
