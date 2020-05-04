package planets;

import bridge.Bridge;
import planets.physics.physicsObjects.Planet;
import planets.render.renderObjects.*;
import ui.SimulationPane;


/**
 * In charge of registering planets.
 * @author David Cosby
 */
public class PlanetManager {
	
	public PlanetManager() {
		
	}
	
	/**
	 * Takes a Planet object and registers it to the simulation by creating a PlanetDisplay and adding the planet to lists that will be used for physics calculations and rendering.
	 * @param p
	 */
	public void registerPlanet(Planet p) {
		Bridge.getProjectData().getPlanets().addPlanet(p);
		PlanetDisplay planetDisplay = new PlanetDisplay(p.getID());
		Bridge.getRenderer().getPlanetDisplayContainer().addPlanetDisplay(planetDisplay);
		Bridge.getRenderer().getSimulationPane().addPlanetDisplay(planetDisplay);
	}
	
	public void removePlanetById(int id) { // this is going to be really ugly, but the alternative was actually worse.
		Planet p = Bridge.getProjectData().getPlanets().getPlanetById(id);
		p.setDeleted(true);
		SimulationPane simp = Bridge.getRenderer().getSimulationPane();
		PlanetDisplay pd = Bridge.getRenderer().getPlanetDisplayContainer().getPlanetDisplayByID(id);
		simp.getChildren().remove(pd);
		pd.setVisible(false);
	}
}
