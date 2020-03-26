package planets.physics;

import bridge.Bridge;
import projectData.PhysicsSettings;
import planets.physics.physicsObjects.*;
import vector.Vector;


public class PhysicsEngine {
	long lastUpdate = System.currentTimeMillis();
	PhysicsSettings settings = Bridge.getProjectData().getSettings().getPhysicsSettings();

	
	public PhysicsEngine() {
		
	}
	
	
	public void updatePosition(Planet p, double deltaSeconds) {
		Vector deltaP = p.getVelocity().mul(deltaSeconds);
		p.setPosition(p.getPosition().add(deltaP));
	}
	
	public void gravitateATowardsB(Planet a, Planet b, double deltaSeconds) {
		double strength = Gravity.calculateForcePairStrengthBetween(a, b);
		// f = m*a
		// a = f/m
		Vector direction = b.getPosition().sub(a.getPosition()).unit();
		Vector acceleration = direction.mul(strength).div(a.getMass()).div(1000);
		
		Vector deltaV = acceleration.mul(deltaSeconds);
		a.setVelocity(a.getVelocity().add(deltaV));
	}
	
	public void calculate() {
		
		if (settings.getPlaying() == true) {
			
			long now = System.currentTimeMillis();
			double deltaSeconds = ((double)(now-lastUpdate) / 1000.0) * settings.getSimulationSpeedScale();
			
			PlanetContainer planets = Bridge.getProjectData().getPlanets();
			int numPlanets = planets.getNumberOfPlanets();
			for (int i = 0; i < numPlanets; i++) {
				Planet p = planets.getPlanetByIndex(i);
				updatePosition(p, deltaSeconds);
				
				for (int i2 = 0; i2 < numPlanets; i2++) {
					Planet p2 = planets.getPlanetByIndex(i2);
					if (p.getID() != p2.getID()) {
						gravitateATowardsB(p, p2, deltaSeconds);
					}
				}
			}	
		}
		lastUpdate = System.currentTimeMillis();
	}
}
