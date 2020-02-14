package planets;

import vectors.Vector;

/**
 * @author David Cosby
 *
 */
/**
 * @author student
 *
 */
/**
 * @author student
 *
 */
public class Planet {
	/**
	 * (kilometers, kilometers)
	 */
	private Vector position;
	/**
	 * kilograms
	 */
	private double mass;
	/**
	 * g/cm^3
	 */
	private double density;
	
	public Planet() {
		position = new Vector(0, 0);
		mass = 7.348e22; // mass and density of the moon, for testing
		density = 3.34;
	}
	
	public Planet(Vector position) {
		this.position = position;
		mass = 7.348e22;
		density = 3.34;
	}
	
	public Planet(Vector position, double mass, double density) {
		this.position = position;
		this.mass = mass;
		this.density = density;
	}

	/**
	 * @return position kilometers
	*/
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector newPosition) {
		position = newPosition;
	}

	/**
	 * @return mass in kilograms
	*/
	public double getMass() {
		return mass;
	}

	public void setMass(double newMass) {
		mass = newMass;
	}
	
	/**
	 * @return density in g/cm^3
	 */
	public double getDensity() {
		return density;
	}

	public void setDensity(double newDensity) {
		density = newDensity;
	}

	
	
	
}
