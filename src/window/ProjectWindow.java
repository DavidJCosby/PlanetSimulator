package window;

import bridge.Bridge;

import javafx.scene.control.SplitPane;
import javafx.scene.layout.*;
import ui.*;
import javafx.beans.value.*;

public class ProjectWindow extends Window {
	private BorderPane borderPane = new BorderPane();
	private BorderPane centerPane = new BorderPane();
	private SplitPane split = new SplitPane();
	private SimulationPane simulationPane = new SimulationPane();
	private PropertiesPane propertiesPane = new PropertiesPane();
	private Timebar timebar = new Timebar();
	private Topbar topbar = new Topbar();
	private Toolbar toolbar = new Toolbar();
	
	
	public ProjectWindow() {
		super();
		setup();
	}
	
	private void setup() {
		borderPane.setCenter(centerPane);
		//centerPane.setLeft(propertiesPane);
		
		
		
		borderPane.setTop(topbar);
		centerPane.setTop(toolbar);
		centerPane.setCenter(simulationPane);
		centerPane.setBottom(timebar);
		
		borderPane.setCenter(split);
		split.getItems().addAll(propertiesPane, centerPane);
		
		getContents().getChildren().add(borderPane);
		Bridge.getRenderer().setSimulationPane(simulationPane);
		borderPane.prefWidthProperty().bind(this.widthProperty());
		borderPane.prefHeightProperty().bind(this.heightProperty());
		
		
		showingProperty().addListener(new ChangeListener<Boolean>() {

		    @Override
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		        if (newValue) {
		            split.setDividerPositions(0.25);
		            observable.removeListener(this);
		        }
		    }

		});


	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
	
}
