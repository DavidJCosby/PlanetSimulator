package ui;

import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import planets.render.renderObjects.PlanetDisplay;


public class SimulationPane extends Pane {
	private Group planetDisplays = new Group();
	private Rectangle clip = new Rectangle();
	
	public SimulationPane() {
		super();
		setup();
	}
	
	private void setup() {
		getChildren().add(planetDisplays);
		//setupClip();
	}
	
	private void setupClip() {
		setClip(clip);
		layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
			clip.setWidth(newValue.getWidth());
			clip.setHeight(newValue.getHeight());
		});
	}
	
	public void addPlanetDisplay(PlanetDisplay planetDisplay) {
		planetDisplays.getChildren().add(planetDisplay);
	}
	
	public Group getPlanetDisplays() {
		return planetDisplays;
	}
}
