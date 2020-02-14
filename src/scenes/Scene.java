package scenes;

import planets.Planet;
import java.util.ArrayList;


/**
 * @author David Cosby
*/

public class Scene {
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private SceneSettings settings = new SceneSettings();
	
	
	public Scene() {
		
	}

	/**
	 * Returns an ArrayList of Planets in the Scene
	 * @return planets - ArrayList of Planets in the Scene
	*/
	public ArrayList<Planet> getPlanets() { // TODO: change from ArrayList to a new Planets class
		return planets;
	}
	
	/**
	 * Returns the Scene's SceneSetting object
	 * @return settings - SceneSetting object
	*/
	public SceneSettings getSettings() {
		return settings;
	}
	
	
}
