package planets.physics;

import planets.physics.physicsObjects.*;
import vector.Vector;

/**
 * Math for calculating and applying gravitational forces on NewtonianObjects
 * @author David Cosby
 */
public class Gravity {
	
	private final static double G = 6.674E-11;
	
	public Gravity() {
		
	}
	
	/**
	 * @param p1 NewtonianObject 1
	 * @param p2 NewtonianObject 2
	 * @return Strength of the Gravitational Force between the two objects in Newtons
	 */
	public static double calculateForcePairStrengthBetween(NewtonianObject p1, NewtonianObject p2) {
		// f = GM1M2/r^2
		Vector pos1 = p1.getPosition().mul(1000); // convert to meters
		Vector pos2 = p2.getPosition().mul(1000);
		
		double distance = pos2.sub(pos1).magnitude();
		
		return ((G * p1.getMass() * p2.getMass()) / Math.pow(distance, 2));
	}


	/**
	 * @param a NewtonianObject A to be pulled towards B
	 * @param b NewtonianObject B that will pull A
	 * @param deltaSeconds time since the last update
	 */
	public static void gravitateATowardsB(NewtonianObject a, NewtonianObject b, double deltaSeconds) {
		double strength = calculateForcePairStrengthBetween(a, b);

		Vector direction = b.getPosition().sub(a.getPosition()).unit();
		Vector acceleration = direction.mul(strength).div(a.getMass()).div(1000);
		
		Vector deltaV = acceleration.mul(deltaSeconds);
		a.setVelocity(a.getVelocity().add(deltaV));
	}
}