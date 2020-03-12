package planets.physics;

import bridge.Bridge;
import projectData.PhysicsSettings;
import planets.physics.physicsObjects.*;

public class PhysicsEngine {
	long lastUpdate = System.currentTimeMillis();
	PhysicsSettings settings = Bridge.getProjectData().getSettings().getPhysicsSettings();

	
	public PhysicsEngine() {
		
	}
	
	public void calculate() {
		
		if (settings.getPlaying() == true) {
			
			long now = System.currentTimeMillis();
			double deltaSeconds = (double)(now-lastUpdate) / 1000.0;
			
			PlanetContainer planets = Bridge.getProjectData().getPlanets();
			int numPlanets = planets.getNumberOfPlanets();
			for (int i = 0; i < numPlanets; i++) {
				Planet p = planets.getPlanetByIndex(i);
				p.setPosition(p.getPosition().add(p.getVelocity().mul(deltaSeconds).mul(settings.getSimulationSpeedScale())));
			}	
		}
		lastUpdate = System.currentTimeMillis();
	}
}
