package planets.physics;

import planets.physics.physicsObjects.*;

public class Gravity {
	
	private final static double G = 6.674E-11;
	
	public Gravity() {
		
	}
	
	public static double calculateForcePairStrengthBetween(Planet p1, Planet p2) {
		// f = GM1M2/r^2
		double distance = p2.getPosition().mul(1000).sub(p1.getPosition().mul(1000)).magnitude();
		
		return (G * p1.getMass() * p2.getMass()) / (distance * distance);
	}

}
