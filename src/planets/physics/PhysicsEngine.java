package planets.physics;

import bridge.Bridge;
import projectData.PhysicsSettings;
import planets.physics.physicsObjects.*;
import vector.Vector;


/**
 * Updates the position and velocity of Planets
 * @author David Cosby
 */
public class PhysicsEngine {
	long lastUpdate = System.currentTimeMillis();
	PhysicsSettings settings = Bridge.getProjectData().getSettings().getPhysicsSettings();

	
	public PhysicsEngine() {
		
	}
	
	/**
	 * @return Seconds since last update
	 */
	private double getDeltaSeconds() {
		long now = System.currentTimeMillis();
		return ((double)(now-lastUpdate) / 1000.0) * settings.getSimulationSpeedScale();
	}
	
	
	/**
	 * Uses the planet's velocity to reposition the planet.
	 * @param p planet whose position needs updating
	 * @param deltaSeconds how long it has been since the last update
	 */
	private void updatePosition(Planet p, double deltaSeconds) {
		Vector deltaP = p.getVelocity().mul(deltaSeconds);
		p.setPosition(p.getPosition().add(deltaP));
	}
	
	
	/**
	 * Fire this to recalculate the positions and velocities of each planet.
	 */
	public void calculate() {
		
		if (settings.getPlaying() == true) {
			PlanetContainer planets = Bridge.getProjectData().getPlanets();
			int numPlanets = planets.getNumberOfPlanets();
			double deltaSeconds = getDeltaSeconds();
			
			for (int i = 0; i < numPlanets; i++) {
				Planet p = planets.getPlanetByIndex(i);
				if (p.getDeleted() == true) {
					continue;
				}
				
				updatePosition(p, deltaSeconds);
				for (int i2 = 0; i2 < numPlanets; i2++) {
					Planet p2 = planets.getPlanetByIndex(i2);
					if (p.getID() != p2.getID()) {
						Gravity.gravitateATowardsB(p, p2, deltaSeconds);
					}
				}
			}
			
		}
		
		lastUpdate = System.currentTimeMillis();
	}
}
