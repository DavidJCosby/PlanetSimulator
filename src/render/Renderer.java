package render;

import render.renderObjects.*;
import vector.Vector;
import bridge.Bridge;
import physics.physicsObject.*;
import projectData.ProjectData;
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
	
	public void render() {
		ProjectData projectData = Bridge.getProjectData();
		Camera camera = projectData.getCamera();
		PlanetContainer planetContainer = projectData.getPlanets();
		Vector screenCenter = new Vector(simulationPane.getWidth(), simulationPane.getHeight()).mul(0.5);
		
		int loopSize = planetContainer.getNumberOfPlanets();
		for (int i = 0; i < loopSize; i++) {
			PlanetDisplay planetDisplay = planetDisplayContainer.getPlanetDisplayByIndex(i);
			Planet planet = planetContainer.getPlanetByIndex(i);
			planetDisplay.setPosition(screenCenter.add(camera.getScreenDisplacementFromCenter(planet.getPosition())));
			planetDisplay.setRadius(camera.getScreenPixelLength(planet.getRadius()));
		}
	}
	
}
