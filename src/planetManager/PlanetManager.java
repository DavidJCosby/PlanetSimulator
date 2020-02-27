package planetManager;

import physics.physicsObject.Planet;
import render.renderObjects.*;
import bridge.Bridge;


public class PlanetManager {
	
	public PlanetManager() {
		
	}
	
	public void registerPlanet(Planet p) {
		Bridge.getProjectData().getPlanets().addPlanet(p);
		PlanetDisplay planetDisplay = new PlanetDisplay(p.getID());
		Bridge.getRenderer().getPlanetDisplayContainer().addPlanetDisplay(planetDisplay);
		Bridge.getRenderer().getSimulationPane().addPlanetDisplay(planetDisplay);
	}
	
}
