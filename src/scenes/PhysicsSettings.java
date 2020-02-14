package scenes;

/**
 * @author David Cosby
 *
 */
public class PhysicsSettings {
	private double simulationSpeedScale;
	private int refreshRateInHertz;
	
	public PhysicsSettings() {
		simulationSpeedScale = 1.0;
		refreshRateInHertz = 60;
	}
	

	public double getSimulationSpeedScale() {
		return simulationSpeedScale;
	}
	
	public void setSimulationSpeedScale(double newSimulationSpeedScale) {
		simulationSpeedScale = newSimulationSpeedScale;
	}

	public int getRefreshRateInHertz() {
		return refreshRateInHertz;
	}
	
	public void setRefreshRateInHertz(int newRefreshRateInHertz) {
		refreshRateInHertz = newRefreshRateInHertz;
	}

	
}
