package scenes;

import planets.PlanetContainer;
import settings.Settings;


/**
 * @author David Cosby
*/

public class Scene {
	private PlanetContainer planets = new PlanetContainer();
	private Settings settings = new Settings();
	
	public Scene() {
		
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
	
	
}
