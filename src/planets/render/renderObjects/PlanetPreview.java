package planets.render.renderObjects;

import javafx.scene.shape.Circle;
import vector.Vector;

/**
 * @author David Cosby
 * Cirlce with a dashed outline used to indicate the size and position of new planets before they are created.
 */
public class PlanetPreview extends Circle {
	/**
	 * (pixels, pixels)
	 */
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
	
	/**
	 * updates the circle's CenterX and CenterY to match the position property
	 */
	private void updatePosition() { 
		this.setCenterX(position.getX());
		this.setCenterY(position.getY());
	}
}
