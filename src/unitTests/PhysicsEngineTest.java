package unitTests;

import static org.junit.jupiter.api.Assertions.*;
import planets.physics.*;
import planets.physics.physicsObjects.*;
import vector.Vector;

import org.junit.jupiter.api.Test;

class PhysicsEngineTest {

	@Test
	void testGravity() {
		
		Gravity g = new Gravity(); // construction
		
		Planet earth = new Planet(new Vector(0, 0), 5.972e24, 5.51);
		Planet human = new Planet(new Vector(earth.getRadius(), 0), 70, 1);
		double acceleration = Gravity.calculateForcePairStrengthBetween(earth, human) / human.getMass();
	
		assertEquals(9.81, acceleration, 0.01);
		
		Gravity.gravitateATowardsB(human, earth, 1);
		// a human should fall 9.81^2 meters in 2 seconds on earth
		assertEquals(earth.getRadius() - (acceleration / 1000), human.getPosition().getX(), 0.01);
	}

}
