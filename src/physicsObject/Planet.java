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
	
	private int ID;
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
		ID = planetsEverCreated + 1;
		name = "Planet";
		planetsEverCreated++;
	}
	
	public int getID() { 
		return ID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public static int getPlanetsEverCreated() {
		return planetsEverCreated;
	}
	
	public double getDensity() {
		return density;
	}


	public void setDensity(double newDensity) {
		density = newDensity;
	}

	
	/**
	 * v = m/d
	 * @return volume
	*/
	public double getVolume() {
		return mass / (density * Rates.G_OVER_CM3_TO_KG_OVER_KM3);
	}
	
	/**
	 * r = cbrt(3v/4pi)
	 * @return radius 
	*/
	public double getRadius() {
		return Math.cbrt((3.0 * getVolume()) / (4.0 * Math.PI)) ;
	}
	
}
