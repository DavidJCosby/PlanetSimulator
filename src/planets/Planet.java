package planets;

import vectors.Vector;

/**
 * @author David Cosby
 *
 */

public class Planet extends NewtonianObject {
	/**
	 * g/cm^3
	*/
	private double density = 3.34;
	
	public Planet() {
		super();
	}
	
	public Planet(Vector position) {
		super(position);
	}
	
	public Planet(Vector position, double mass, double density) {
		super(position, mass);
		this.density = density;
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
