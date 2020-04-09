package ui.drawer;

import planets.physics.physicsObjects.Planet;
import bridge.Bridge;


public class DrawerController {

	private Planet currentPlanet;
	DataDrawer data;
	
	
	public DrawerController() {
	}
	
	public void selectedPlanet(Planet p) {
		currentPlanet = p;
		updateOneTimePlanetInformation();
		
		if (Bridge.getProjectData().getSettings().getPhysicsSettings().getPlaying() == true) {
			data.setOpenForChanges(false);
		}
		else {
			data.setOpenForChanges(true);
		}
	}
	
	public void deselectedPlanet() {
		currentPlanet = null;
		data.setNameTo("");
		data.setMassTo(0);
		data.setRadiusTo(0);
		data.setDensityTo(0);
		data.setOpenForChanges(false);
	}
	
	
	private void updateOneTimePlanetInformation() {
		data = Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getDataDrawer();

		data.setNameTo(currentPlanet.getName());
		data.setMassTo(currentPlanet.getMass());
		data.setRadiusTo(currentPlanet.getRadius());
		data.setDensityTo(currentPlanet.getDensity());
	}
	
	public void setOpenForChanges(boolean open) {
		if (currentPlanet != null) {
			data.setOpenForChanges(open);
		}
	}
	
	public void updateRealtimePlanetInformation() {
		
	}
	
}
