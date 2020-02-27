package physics;

import bridge.Bridge;
import physics.physicsObject.*;

public class PhysicsEngine {
	long lastUpdate = System.currentTimeMillis();
	
	
	public PhysicsEngine() {
		
	}
	
	public void calculate() {
		long now = System.currentTimeMillis();
		double deltaSeconds = (double)(now-lastUpdate) / 1000.0;
		
		PlanetContainer planets = Bridge.getProjectData().getPlanets();
		int numPlanets = planets.getNumberOfPlanets();
		for (int i = 0; i < numPlanets; i++) {
			Planet p = planets.getPlanetByIndex(i);
			p.setPosition(p.getPosition().add(p.getVelocity().mul(deltaSeconds)));
		}
		
		lastUpdate = System.currentTimeMillis();
	}
}
