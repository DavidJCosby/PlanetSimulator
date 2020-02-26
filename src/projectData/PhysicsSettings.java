package projectData;

/**
 * Settings specific to the Physics Engine.
 * @author David Cosby
 */
public class PhysicsSettings {
	/**
	 * Speed multiplier for simulated objects
	 */
	private double simulationSpeedScale;
	/**
	 * Rate at which object positions and velocities are calculated
	 */
	private int refreshRateInHertz;
	
	public PhysicsSettings() {
		simulationSpeedScale = 1.0;
		refreshRateInHertz = 60;
	}
	

	public double getSimulationSpeedScale() {
		return simulationSpeedScale;
	}
	
	/**
	 * @param newSimulationSpeedScale new speed multiplier for simulated objects
	 */
	public void setSimulationSpeedScale(double newSimulationSpeedScale) {
		simulationSpeedScale = newSimulationSpeedScale;
	}

	public int getRefreshRateInHertz() {
		return refreshRateInHertz;
	}
	
	/**
	 * @param newRefreshRateInHertz new rate at which object positions and velocities will be calculated.
	 */
	public void setRefreshRateInHertz(int newRefreshRateInHertz) {
		refreshRateInHertz = newRefreshRateInHertz;
	}

	
}
