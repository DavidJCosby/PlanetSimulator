package planets;

import bridge.Bridge;
import planets.physics.physicsObjects.Planet;
import planets.render.renderObjects.*;
import ui.SimulationPane;


/**
 * In charge of registering planets. Adds Planet objects to the PlanetContainer, creates PlanetDisplays and adds those to the PlanetDisplayContainer.
 * @author David Cosby
 */
public class PlanetManager {
	
	public PlanetManager() {
		
	}
	
	/**
	 * Takes a Planet object and registers it to the simulation by creating a PlanetDisplay and adding the planet to lists that will be used for physics calculations and rendering.
	 * @param p Planet to be registered.
	 */
	public void registerPlanet(Planet p) {
		Bridge.getProjectData().getPlanets().addPlanet(p);
		PlanetDisplay planetDisplay = new PlanetDisplay(p.getID());
		Bridge.getRenderer().getPlanetDisplayContainer().addPlanetDisplay(planetDisplay);
		Bridge.getRenderer().getSimulationPane().addPlanetDisplay(planetDisplay);
	}
	
	/**
	 * Marks the planet with this id as deleted, so that the render and physics engines will skip over it, and makes the PlanetDisplay invisible.
	 * @param id identifier of the planet to be removed
	 */
	public void removePlanetById(int id) { // this is ugly, but the alternative was actually worse.
		Planet p = Bridge.getProjectData().getPlanets().getPlanetById(id);
		p.setDeleted(true);
		SimulationPane simp = Bridge.getRenderer().getSimulationPane();
		PlanetDisplay pd = Bridge.getRenderer().getPlanetDisplayContainer().getPlanetDisplayByID(id);
		simp.getChildren().remove(pd);
		pd.setVisible(false);
	}
}
