package window;

import bridge.Bridge;

import javafx.scene.layout.*;
import ui.*;

public class ProjectWindow extends Window {
	private BorderPane borderPane = new BorderPane();
	private SimulationPane simulationPane = new SimulationPane();
	private Topbar topbar = new Topbar();
	
	public ProjectWindow() {
		super();
		setup();
	}
	
	private void setup() {
		borderPane.setCenter(simulationPane);
		borderPane.setTop(topbar);
		getContents().getChildren().add(borderPane);
		Bridge.getRenderer().setSimulationPane(simulationPane);
		borderPane.prefWidthProperty().bind(this.widthProperty());
		borderPane.prefHeightProperty().bind(this.heightProperty());

	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
	
}
