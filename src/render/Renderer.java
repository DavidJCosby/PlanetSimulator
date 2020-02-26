package render;

import render.renderObjects.*;
import bridge.Bridge;


/**
 * In charge of drawing planets to the SimulationPane and updating their position at the request of the Scheduler.
 * @author David Cosby
 */
public class Renderer {
	private PlanetDisplayContainer planetDisplayContainer = new PlanetDisplayContainer();

	public Renderer() {

	}
	
	public PlanetDisplayContainer getPlanetDisplayContainer() {
		return planetDisplayContainer;
	}
	
}
