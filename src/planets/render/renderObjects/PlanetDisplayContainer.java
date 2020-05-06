package planets.render.renderObjects;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author David Cosby
 * Contains all of the PlanetDisplays in a simulation.
 */
public class PlanetDisplayContainer {	
	private ArrayList<PlanetDisplay> planetDisplays = new ArrayList<PlanetDisplay>();
	
	private HashMap<Integer, PlanetDisplay> planetDisplaysByID = new HashMap<Integer, PlanetDisplay>();

	
	public PlanetDisplayContainer() {
		
	}
	
	/**
	 * @param planetDisplay planetDisplay to be registered to the DisplayContainer
	 */
	public void addPlanetDisplay(PlanetDisplay planetDisplay) {
		planetDisplays.add(planetDisplay);
		planetDisplaysByID.put(planetDisplay.getID(), planetDisplay);
	}
	
	/**
	 * @param index Index of the PlanetDisplay we are looking for. Recommended for when iterating over a list of PlanetDisplays.
	 * @return PlanetDisplay with the requested index.
	 */
	public PlanetDisplay getPlanetDisplayByIndex(int index) {
		return planetDisplays.get(index);
	}
	
	/**
	 * @param ID ID of the PlanetDisplay we are looking for. Recommended for when grabbing just one PlanetDisplay.
	 * @return PlanetDisplay with the requested index.
	 */
	public PlanetDisplay getPlanetDisplayByID(int ID) {
		return planetDisplaysByID.get(ID);
	}
	
	/**
	 * @return integer representing how many planetDisplays we have registered.
	 */
	public int getNumberOfPlanetDisplays() {
		return planetDisplays.size();
	}
	
	
}
