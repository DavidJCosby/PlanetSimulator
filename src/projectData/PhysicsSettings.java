package projectData;

import bridge.Bridge;

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
	 * Rate at which object positions and velocities are calculated. Not currently being used due to the way the scheduler works.
	 */
	private int refreshRateInHertz;
	
	/**
	 * Like a pause feature, determines whether we should be calculating new planet positions or idling.
	 */
	private boolean playing;
	

	
	public PhysicsSettings() {
		simulationSpeedScale = 1.0;
		refreshRateInHertz = 60; // don't think this value is actually used.
		playing = true;
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
	
	public boolean getPlaying() {
		return playing;
	}
	
	public void setPlaying(boolean newPlaying) {
		playing = newPlaying;
		Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getController().setOpenForChanges(!newPlaying);

	}

	
}
