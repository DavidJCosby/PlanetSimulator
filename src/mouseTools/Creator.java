package mouseTools;

import bridge.Bridge;
import bridge.Tools;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import planets.physics.physicsObjects.*;
import ui.SimulationPane;
import vector.Vector;
import planets.render.Camera;
import planets.render.renderObjects.PlanetPreview;

public class Creator extends MouseTool {
	
	private PlanetPreview planetPreview = Bridge.getRenderer().getPlanetPreview();
	private Planet defaultPlanet = new Planet();
	private Camera cam = Bridge.getProjectData().getCamera();
	private Vector lastPos = new Vector();
	private String defaultName = "DEFAULT PLANET";
	
	public Creator() {
		defaultPlanet.setName(defaultName);
	}
	
	
	private Vector mouseToWorldPos(MouseEvent e) {
		Vector screenPos = new Vector(e.getX(), e.getY());
		SimulationPane simPane = Bridge.getWindowManager().getProjectWindow().getSimulationPane();
		Vector screenCenter = new Vector(simPane.getWidth()/2, simPane.getHeight()/2);
		Vector relativeToCenter = screenPos.sub(screenCenter);
		Vector pos = cam.getVectorDisplacementFromPixelDisplacement(relativeToCenter).add(cam.getOffset()).add(cam.getPosition());
		
		return pos;
	}
	
	private Planet roughCloneDefaultPlanet() {
		Planet c = new Planet();
		c.setDensity(defaultPlanet.getDensity());
		c.setMass(defaultPlanet.getMass());
		c.setName(defaultPlanet.getName());
		c.setVelocity(defaultPlanet.getVelocity());

		if (c.getName().equals(defaultName)) {
			c.setName("Planet" + c.getID());
		}
		
		return c;
	}
	
	private void updatePlanetDisplay() {
		Vector screenPos = lastPos;
		double radius = cam.getScreenPixelLength(defaultPlanet.getRadius());
		
		planetPreview.setPosition(screenPos);
		planetPreview.setRadius(radius);
	}
	
	public void onMouseDown(MouseEvent e) {
		Planet p = roughCloneDefaultPlanet();
		Vector clickedPos = mouseToWorldPos(e);
		p.setPosition(clickedPos);
		Bridge.getPlanetManager().registerPlanet(p);
		
		
	}
	public void onMouseUp(MouseEvent e) {
		
		
	}
	public void onMouseMove(MouseEvent e) {
		lastPos = new Vector(e.getX(), e.getY());
		updatePlanetDisplay();
		
	}
	public void onScroll(ScrollEvent e) {
		Tools.DRAG.onScroll(e);
		updatePlanetDisplay();
	}
	
	public void onEquip() {
		planetPreview.setVisible(true);
		Bridge.getProjectData().setSelection(null);
		Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getController().selectedPlanet(defaultPlanet);
	}
	
	public void onUnequip() {
		planetPreview.setVisible(false);
	}
	
	public Planet getDefaultPlanet() {
		return defaultPlanet;
	}
	
}
