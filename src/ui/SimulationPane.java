package ui;

import javafx.scene.layout.Pane;
import bridge.Bridge;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import planets.render.renderObjects.PlanetDisplay;
import projectData.ProjectData;
import mouseTools.*;


/**
 * Pane that holds PlanetDisplays and listens for MouseEvents to be routed to MouseTools.
 * @author David Cosby
 */
public class SimulationPane extends Pane {
	private Group planetDisplays = new Group();
	private Rectangle clip = new Rectangle();
	
	public SimulationPane() {
		super();
		setup();
	}
	
	private void setup() {
		getChildren().add(planetDisplays);
		setId("bg");
		setupClip();
		connectMouseEvents();
	}
	
	private void setupClip() {
		setClip(clip);
		layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
			clip.setWidth(newValue.getWidth());
			clip.setHeight(newValue.getHeight());
		});
	}
	
	private void connectMouseEvents() {
		ProjectData data = Bridge.getProjectData();
		
		setOnMousePressed((event) -> {
			data.getCurrentTool().onMouseDown(event);
		});
		
		setOnMouseReleased((event) -> {
			data.getCurrentTool().onMouseUp(event);
		});
		
		setOnMouseDragged((event) -> {
			if (data.getCurrentTool() instanceof Dragger ) {
				data.getCurrentTool().onMouseMove(event);
			}
		});
		
		setOnMouseMoved((event) -> {
			if (data.getCurrentTool() instanceof Creator ) {
				data.getCurrentTool().onMouseMove(event);
			}
		});
		
		setOnScroll((event) -> {
			data.getCurrentTool().onScroll(event);
		});
	}
	
	
	public void addPlanetDisplay(PlanetDisplay planetDisplay) {
		planetDisplays.getChildren().add(planetDisplay);
	}
	
	public Group getPlanetDisplays() {
		return planetDisplays;
	}
}
