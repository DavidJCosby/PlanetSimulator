package planets.render.renderObjects;

import javafx.scene.shape.Circle;
import vector.Vector;

public class PlanetPreview extends Circle {
	private Vector position = new Vector();

	public PlanetPreview() {
		setId("preview");
		setRadius(0);
		setVisible(false);
	}
	
	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
		updatePosition();
	}
	
	private void updatePosition() {
		this.setCenterX(position.getX());
		this.setCenterY(position.getY());
	}
}
