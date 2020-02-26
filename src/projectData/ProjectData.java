package projectData;

import physicsObject.PlanetContainer;
import render.Camera;


/**
 * Contains only data relating to the project that needs to be saved and loaded.
 * @author David Cosby
*/
public class ProjectData {
	private PlanetContainer planets = new PlanetContainer();
	private Settings settings = new Settings();
	private Camera camera = new Camera();
	
	public ProjectData() {
		
	}


	public PlanetContainer getPlanets() { 
		return planets;
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public Camera getCamera() {
		return camera;
	}

}
