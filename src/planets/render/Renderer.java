package planets.render;

import vector.Vector;
import bridge.Bridge;
import planets.physics.physicsObjects.*;
import planets.render.renderObjects.*;
import projectData.ProjectData;
import ui.SimulationPane;
import window.WindowManager;



/**
 * In charge of drawing planets to the SimulationPane and updating their position at the request of the Scheduler.
 * @author David Cosby
 */
public class Renderer {
	private PlanetDisplayContainer planetDisplayContainer = new PlanetDisplayContainer();
	private SimulationPane simulationPane;
	
	
	public Renderer() {
		
	}
	
	public void setSimulationPane(SimulationPane newSimulationPane) {
		simulationPane = newSimulationPane;
	}
	
	public SimulationPane getSimulationPane() {
		return simulationPane;
	}
	
	public PlanetDisplayContainer getPlanetDisplayContainer() {
		return planetDisplayContainer;
	}
	
	private void selectionFlash(PlanetDisplay planetDisplay) {
		double now = (double)System.currentTimeMillis();
		double multiplier = Math.sin(now / 200) / 2 + 1.5;
		planetDisplay.setStrokeWidth(multiplier * 4);
	}
	
	
	public void render() {
		ProjectData projectData = Bridge.getProjectData();
		Camera camera = projectData.getCamera();
		PlanetContainer planetContainer = projectData.getPlanets();
		Vector screenCenter = new Vector(simulationPane.getWidth(), simulationPane.getHeight()).mul(0.5);
		
		int loopSize = planetContainer.getNumberOfPlanets();
		for (int i = 0; i < loopSize; i++) {
			PlanetDisplay planetDisplay = planetDisplayContainer.getPlanetDisplayByIndex(i);
			planetDisplay.setStrokeWidth(0); // hacky default
			if (projectData.getSelection() != null) {
				if (projectData.getSelection().getID() == planetDisplay.getID()) {
					selectionFlash(planetDisplay);
				}
			}
			Planet planet = planetContainer.getPlanetByIndex(i);
			planetDisplay.setPosition(screenCenter.add(camera.getScreenDisplacementFromCenter(planet.getPosition())));
			planetDisplay.setRadius(camera.getScreenPixelLength(planet.getRadius()));
		}
	}
	
}
