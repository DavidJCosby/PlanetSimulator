package planets.render.renderObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanetDisplayContainer {
	
	private ArrayList<PlanetDisplay> planetDisplays = new ArrayList<PlanetDisplay>();
	
	private HashMap<Integer, PlanetDisplay> planetDisplaysByID = new HashMap<Integer, PlanetDisplay>();

	
	public PlanetDisplayContainer() {
		
	}
	
	public void addPlanetDisplay(PlanetDisplay planetDisplay) {
		planetDisplays.add(planetDisplay);
		planetDisplaysByID.put(planetDisplay.getID(), planetDisplay);
	}
	
	public PlanetDisplay getPlanetDisplayByIndex(int index) {
		return planetDisplays.get(index);
	}
	
	public PlanetDisplay getPlanetDisplayByID(int ID) {
		return planetDisplaysByID.get(ID);
	}
	
	public int getNumberOfPlanetDisplays() {
		return planetDisplays.size();
	}
	
}
