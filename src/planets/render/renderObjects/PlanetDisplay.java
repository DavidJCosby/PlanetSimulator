package planets.render.renderObjects;

import vector.Vector;

import planets.physics.physicsObjects.*;
import javafx.scene.shape.Circle;
import bridge.Bridge;
import javafx.scene.paint.*;

/**
 * Circle to be rendered that represents a planet.
 * @author David Cosby
 */
public class PlanetDisplay extends Circle {
	private Vector position = new Vector();
	private int ID;
	
	
	public PlanetDisplay(int ID) {
		this.ID = ID;
		this.setId("Planet");
		createSelf();
		connectMouseEvents();
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
	//	this.setStroke(Color.web("#ffffff")); // TODO: replace with CSS
		//this.setFill(Color.web("#859900"));
		this.toBack();
	}
	
	private void connectMouseEvents() {
		setOnMousePressed((event) -> {
			Planet p = Bridge.getProjectData().getPlanets().getPlanetById(this.ID);
			Bridge.getProjectData().setSelection(p);
			Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getController().selectedPlanet(p);
		});
	}
	
	private void updatePosition() {
		this.setCenterX(position.getX());
		this.setCenterY(position.getY());
	}
}
