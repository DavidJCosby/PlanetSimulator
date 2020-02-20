package planets;

import unitConversion.Rates;
import vectors.Vector;

/**
 *  All Planets have a density, and therefore, radius and volume.
 * @author David Cosby
 */

public class Planet extends NewtonianObject {
	/**
	 * (g/cm^3)
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

	
	/**
	 * @return volume in km^3
	*/
	public double getVolume() {
		return mass / (density * Rates.G_OVER_CM3_TO_KG_OVER_KM3);
	}
	
	public double getRadius() {
		return Math.pow((3.0 * getVolume()) / (4.0 * Math.PI), 1.0/3.0) ;
	}
	
	
	
}
