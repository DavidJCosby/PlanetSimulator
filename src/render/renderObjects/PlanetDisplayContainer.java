package render.renderObjects;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanetDisplayContainer {
	
	private ArrayList<PlanetDisplay> planetDisplays = new ArrayList<PlanetDisplay>();
	
	private HashMap<Integer, PlanetDisplay> planetDisplaysByID = new HashMap<Integer, PlanetDisplay>();

	
	public PlanetDisplayContainer() {
		
	}
	
	public void addPlanetDisplay(PlanetDisplay renderObject) {
		planetDisplays.add(renderObject);
		planetDisplaysByID.put(renderObject.getID(), renderObject);
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