package projectData;

import physicsObject.PlanetContainer;
import render.Camera;


/**
 * @author David Cosby
*/
public class ProjectData {
	private PlanetContainer planets = new PlanetContainer();
	private Settings settings = new Settings();
	private Camera camera = new Camera();
	
	public ProjectData() {
		
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
