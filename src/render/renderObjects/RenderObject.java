package render.renderObjects;

import vector.Vector;

import javafx.scene.shape.Circle;
import javafx.scene.paint.*;

/**
 * @author David Cosby
 */
public class RenderObject extends Circle {
	private Vector position = new Vector();
	private int ID;
	
	
	public RenderObject(int ID) {
		this.ID = ID;
		createSelf();
	}
	
	
	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
		updatePosition();
	}

	public Vector getPosition() {
		return position;
	}
	
	public void setID(int newID) {
		ID = newID;
	}
	
	public int getID() {
		return ID;
	}
	
	private void createSelf() {
		this.setStroke(Color.BLACK);
		this.setFill(Color.web("#859900"));
	}
	
	private void updatePosition() {
		this.setCenterX(position.getX());
		this.setCenterY(position.getY());
	}
}
