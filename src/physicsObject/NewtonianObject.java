package physicsObject;

import vector.Vector;

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
	 * (kilograms)
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
	 * @return position in kilometers
	*/
	public Vector getPosition() {
		return position;
	}

	public void setPosition(Vector newPosition) {
		position.set(newPosition.getX(), newPosition.getY());
	}
	
	/**
	 * @return velocity in kilometers/second
	*/
	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector newVelocity) {
		velocity.set(newVelocity.getX(), newVelocity.getY());
	}
	
	public void addVelocity(Vector deltaVelocity) {
		velocity = velocity.add(deltaVelocity);
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
	 * @return momentum in kilograms * kilometers / seconds
	*/
	public Vector getMomentum() {
		return velocity.mul(mass);
	}
	
	/**
	 * @param MomentumVector Amount of momentum to be applied to the NewtonianObject
	 */
	public void applyMomentum(Vector MomentumVector) {
		Vector velocityToAdd = MomentumVector.div(mass);
		velocity = velocity.add(velocityToAdd);
	}
	
}
