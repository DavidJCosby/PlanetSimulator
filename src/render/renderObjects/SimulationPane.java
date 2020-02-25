package render.renderObjects;

import javafx.scene.layout.Pane;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;


public class SimulationPane extends Pane {
	private Group renderObjects = new Group();
	private Rectangle clip = new Rectangle();
	
	public SimulationPane() {
		super();
		setup();
	}
	
	private void setup() {
		getChildren().add(renderObjects);
		setupClip();
	}
	
	private void setupClip() {
		setClip(clip);
		layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
			clip.setWidth(newValue.getWidth());
			clip.setHeight(newValue.getHeight());
		});
	}
	
	public void addRenderObject(RenderObject renderObject) {
		renderObjects.getChildren().add(renderObject);
	}
}
