package scenes;

import planets.Planet;
import java.util.ArrayList;


/**
 * @author David Cosby
*/

public class Scene {
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	private Settings settings = new Settings();
	
	
	public Scene() {
		
	}

	/**
	 * @return planets - ArrayList of Planets in the Scene
	*/
	public ArrayList<Planet> getPlanets() { // TODO: change from ArrayList to a new Planets class
		return planets;
	}
	
	/**
	 * @return settings - SceneSetting object
	*/
	public Settings getSettings() {
		return settings;
	}
	
	
}
