package window;

import bridge.Bridge;

import javafx.scene.layout.*;
import ui.*;

public class ProjectWindow extends Window {
	private BorderPane borderPane = new BorderPane();
	private BorderPane centerPane = new BorderPane();
	private SimulationPane simulationPane = new SimulationPane();
	private Topbar topbar = new Topbar();
	private Toolbar toolbar = new Toolbar();
	
	
	public ProjectWindow() {
		super();
		setup();
	}
	
	private void setup() {
		borderPane.setCenter(centerPane);
		borderPane.setTop(topbar);
		centerPane.setTop(toolbar);

		centerPane.setCenter(simulationPane);
		getContents().getChildren().add(borderPane);
		Bridge.getRenderer().setSimulationPane(simulationPane);
		borderPane.prefWidthProperty().bind(this.widthProperty());
		borderPane.prefHeightProperty().bind(this.heightProperty());

	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
	
}
