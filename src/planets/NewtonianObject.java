package planets;

import vectors.Vector;

/**
 * All Newtonian objects have position, velocity, and mass.
 * @author David Cosby
 */

public class NewtonianObject {
	/**
	 * (kilometers, kilometers)
	 */
	protected Vector position = new Vector();
	/**
	 * (kilometers/second, kilometers/second)
	 */
	protected Vector velocity = new Vector();
	/**
	 * kilograms
	 */
	protected double mass = 7.348e22;
	
	
	public NewtonianObject() {
		
	}
	
	public NewtonianObject(Vector position) {
		this.position.set(position.getX(), position.getY());
	}
	
	public NewtonianObject(Vector position, double mass) {
		this.position.set(position.getX(), position.getY());
		this.mass = mass;
	}
	
	
	/**
	 * @return position kilometers
	*/
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
	}
	
	/**
	 * @return velocity kilometers/second
	*/
	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector newVelocity) {
		velocity.set(newVelocity.getX(), newVelocity.getY());
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
	
}
