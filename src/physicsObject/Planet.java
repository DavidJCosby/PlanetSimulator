package physicsObject;

import unitConversion.Rates;
import vector.Vector;

/**
 *  All Planets have a density, and therefore, radius and volume.
 * @author David Cosby
 */

public class Planet extends NewtonianObject {
	/**
	 * (g/cm^3)
	*/
	private double density = 3.34;
	
	private int id;
	private String name;
	private static int planetsEverCreated;
	
	public Planet() {
		super();
		establishIdentity();
	}
	
	public Planet(Vector position) {
		super(position);
		establishIdentity();
	}
	
	public Planet(Vector position, double mass, double density) {
		super(position, mass);
		this.density = density;
		establishIdentity();
	}
	
	private void establishIdentity() {
		id = planetsEverCreated + 1;
		name = "Planet";
		planetsEverCreated++;
	}
	
	/**
	 * @return unique identifier for the planet
	 */
	public int getId() { 
		return id;
	}
	
	/**
	 * @return name planet's current name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param newName planet's new name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	/**
	 * @return planetsEverCreated number of planets the system has created
	 */
	public static int getPlanetsEverCreated() {
		return planetsEverCreated;
	}
	
	/**
	 * @return density in g/cm^3
	 */
	public double getDensity() {
		return density;
	}

	/**
	 * @param newDensity density is set to
	 */
	public void setDensity(double newDensity) {
		density = newDensity;
	}

	
	/**
	 * v = m/d
	 * @return volume in km^3
	*/
	public double getVolume() {
		return mass / (density * Rates.G_OVER_CM3_TO_KG_OVER_KM3);
	}
	
	/**
	 * r = cbrt(3v/4pi)
	 * @return radius in km
	*/
	public double getRadius() {
		return Math.cbrt((3.0 * getVolume()) / (4.0 * Math.PI)) ;
	}
	
}
