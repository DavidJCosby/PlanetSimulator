package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vector.Vector;

/**
 * Tests vector methods for correctness.
 * @author David Cosby
 */
class VectorTest {

	private void compareVectors(Vector a, Vector b) {
		assertEquals(a.getX(), b.getX());
		assertEquals(a.getY(), b.getY());
	}

	@Test
	void testConstruction() {
		Vector v = new Vector(5, -6);
		assertEquals(v.getX(), 5);
		assertEquals(v.getY(), -6);
		v = new Vector();
	}

	@Test
	void testAddition() {
		Vector v = new Vector(-2, 4);
		v = v.add(new Vector(3, -2));

		Vector comp = new Vector(1, 2);
		compareVectors(comp, v);
		
		v = v.add(1, 2);
		compareVectors(new Vector(2, 4), v);
				
	}

	@Test
	void testSubtraction() {
		Vector v = new Vector(2, -4);
		v = v.sub(new Vector(-3, 2));

		Vector comp = new Vector(5, -6);
		compareVectors(comp, v);
		
		v = v.sub(1, 2);
		compareVectors(new Vector(4, -8), v);
	}

	@Test
	void testMultiplication() {
		Vector v = new Vector(2, -4);
		v = v.mul(new Vector(3, -4));

		Vector comp = new Vector(6, 16);
		compareVectors(comp, v);
		
		v = v.mul(0.5, 2);
		compareVectors(new Vector(3, 32), v);
		
		v = v.mul(2.0);
		compareVectors(new Vector(6, 64), v);

	}

	@Test
	void testDivision() {
		Vector v = new Vector(-2, 4);
		v = v.div(new Vector(3, -4));

		Vector comp = new Vector(-2.0 / 3.0, -1);
		compareVectors(comp, v);
		
		v = v.div(0.5, 2);
		compareVectors(new Vector(-4.0 / 3.0, -0.5), v);
		
		v = v.div(2.0);
		compareVectors(new Vector(-2.0 / 3.0, -0.25), v);
	}

	@Test
	void testSet() {
		Vector v = new Vector();
		v.set(1, 3);
		compareVectors(new Vector(1, 3), v);
		
		v.setX(-7);
		v.setY(2);
		
		compareVectors(new Vector(-7, 2), v);
	}
	
	@Test
	void testToString() {
		Vector v = new Vector();
		String str = v.toString();
		assertNotNull(str);
	}
	
	@Test
	void testMagnitude() {
		Vector v = new Vector(3, 4);
		assertEquals(v.magnitude(), 5);

		v = new Vector(-60, 40);
		double expected = Math.sqrt(5200);
		assertEquals(v.magnitude(), expected);
	}

	@Test
	void testUnit() {
		Vector v = new Vector(-1.0, 1.0).unit();
		Vector comp = new Vector(-1.0 / Math.sqrt(2.0), 1.0 / Math.sqrt(2.0));
		compareVectors(comp, v);
		
		v = new Vector(3.0, -4.0).unit();
		comp = new Vector(0.6, -0.8);
		compareVectors(comp, v);
		
		v = new Vector(0, 0).unit();
		compareVectors(new Vector(0, 0), v);
	}

}
