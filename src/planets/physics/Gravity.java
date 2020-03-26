package planets.physics;

import planets.physics.physicsObjects.*;
import vector.Vector;

public class Gravity {
	
	private final static double G = 6.674E-11;
	
	public Gravity() {
		
	}
	
	public static double calculateForcePairStrengthBetween(Planet p1, Planet p2) {
		// f = GM1M2/r^2
		Vector pos1 = p1.getPosition().mul(1000); // convert to meters
		Vector pos2 = p2.getPosition().mul(1000);
		
		double distance = pos2.sub(pos1).magnitude();
		
		return ((G * p1.getMass() * p2.getMass()) / Math.pow(distance, 2));
	}


	public static void gravitateATowardsB(Planet a, Planet b, double deltaSeconds) {
		double strength = calculateForcePairStrengthBetween(a, b);

		Vector direction = b.getPosition().sub(a.getPosition()).unit();
		Vector acceleration = direction.mul(strength).div(a.getMass()).div(1000);
		
		Vector deltaV = acceleration.mul(deltaSeconds);
		a.setVelocity(a.getVelocity().add(deltaV));
	}
}