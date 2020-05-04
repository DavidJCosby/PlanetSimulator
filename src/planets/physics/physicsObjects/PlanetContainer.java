package planets.physics.physicsObjects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains all of the planets in a ProjectData object.
 * @author David Cosby
 */
public class PlanetContainer {
	
	
	/**
	 * List of Planets in order of registration. Use, paired with getNumberOfPlanets(), when you need to loop through a list.
	 */
	private ArrayList<Planet> planets = new ArrayList<Planet>();
	/**
	 * Map of Planet Id's (key) to Planets (value). Use when you need to retrieve a specific planet. 
	 */
	private HashMap<Integer, Planet> planetsByID = new HashMap<Integer, Planet>();
	
	
	public PlanetContainer() {
		
	}
	
	/**
	 * @param planet new planet to register to the PlanetContainer
	 */
	public void addPlanet(Planet planet) {
		planets.add(planet);
		planetsByID.put(planet.getID(), planet);
	}
	
	/**
	 * @param index position in the planets ArrayList
	 * @return planet of requested index
	 */
	public Planet getPlanetByIndex(int index) {
		return planets.get(index);
	}
	
	/**
	 * @param ID identifier of the requested planet
	 * @return planet of requested id
	 */
	public Planet getPlanetById(int ID) {
		return planetsByID.get(ID);
	}
	
	
	/**
	 * Removes the planet from the registry. Hopefully java has garbage collection that will clean this up?
	 * @param ID identifier of the requested planet
	 */
	public void removePlanetById(int ID) {
		int counter = 0;
		
		for (Planet p : planets) {
			if (p.getID() == ID ) {
				break;
			}
			counter++;
		}
		
		planets.remove(counter);
	}
	
	
	/**
	 * @return number of planets registered in the PlanetContainer
	 */
	public int getNumberOfPlanets() {
		return planets.size();
	}
	

	
}
