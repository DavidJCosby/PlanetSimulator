package planets;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains all of the planets in a scene.
 * @author David Cosby
 */
public class PlanetContainer {
	/**
	 * List of Planets in order of registration. Use, paired with getNumberOfPlanets(), when you need to loop through a list.
	 */
	ArrayList<Planet> planets = new ArrayList<Planet>();
	/**
	 * Map of Planet Id's (key) to Planets (value). Use when you need to retrieve a specific planet. 
	 */
	HashMap<Integer, Planet> planetsById = new HashMap<Integer, Planet>();
	
	
	public PlanetContainer() {
		
	}
	
	/**
	 * @param planet new planet to register to the PlanetContainer
	 */
	public void addPlanet(Planet planet) {
		planets.add(planet);
		planetsById.put(planet.getId(), planet);
	}
	
	/**
	 * @param index position in the planets ArrayList
	 * @return planet of requested index
	 */
	public Planet getPlanetByIndex(int index) {
		return planets.get(index);
	}
	
	/**
	 * @param id identifier of the requested planet
	 * @return planet of requested id
	 */
	public Planet getPlanetById(int id) {
		return planetsById.get(id);
	}
	
	
	/**
	 * @return number of planets registered in the PlanetContainer
	 */
	public int getNumberOfPlanets() {
		return planets.size();
	}
	
}
