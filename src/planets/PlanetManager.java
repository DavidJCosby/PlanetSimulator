package planets;

import bridge.Bridge;
import planets.physics.physicsObjects.Planet;
import planets.render.renderObjects.*;


/**
 * In charge of registering planets.
 * @author David Cosby
 */
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
