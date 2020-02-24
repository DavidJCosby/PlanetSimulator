package scene;

import physicsObject.PlanetContainer;
import render.Camera;
import settings.Settings;


/**
 * @author David Cosby
*/
public class SimulationScene {
	private PlanetContainer planets = new PlanetContainer();
	private Settings settings = new Settings();
	private Camera camera = new Camera();
	
	public SimulationScene() {
		
	}

	/**
	 * @return planets - Container of Planets in the Scene
	*/
	public PlanetContainer getPlanets() { 
		return planets;
	}
	
	/**
	 * @return settings - SceneSetting object
	*/
	public Settings getSettings() {
		return settings;
	}
	
	/**
	 * @return camera - Scene's current camera object
	 */
	public Camera getCamera() {
		return camera;
	}

}
