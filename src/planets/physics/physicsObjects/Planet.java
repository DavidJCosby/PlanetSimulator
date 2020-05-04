package planets.physics.physicsObjects;

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
	
	/**
	 * Identifier unique to this planet.
	 */
	private int ID;
	/**
	 * The name or title for the planet. Planets may share the same name without error.
	 */
	private String name;
	/**
	 * A record of how many planets have ever been created. Used to generate IDs.
	 */
	private static int planetsEverCreated;
	
	/**
	 * Ugly deletion technique. When this is true, the render and physics engine will pass over this planet.
	 */
	private boolean deleted = false;
	
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
		name = "Planet" + ID;
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
	
	/**
	 * When true, the renderer and physics engine will skip over this planet. Ugly and wrong, I know.
	 * @param del 
	 */
	public void setDeleted(boolean del) {
		deleted = del;
	}
	
	public boolean getDeleted() {
		return deleted;
	}
	
}
