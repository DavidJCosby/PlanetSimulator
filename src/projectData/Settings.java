package projectData;

/**
 * Contains all sub-categories for settings.
 * @author David Cosby
 */
public class Settings {
	private PhysicsSettings physics = new PhysicsSettings();
	private RenderSettings render = new RenderSettings();
	private ControlSettings control = new ControlSettings();

	public Settings() {
		
	}

	public PhysicsSettings getPhysicsSettings() {
		return physics;
	}
	
	public RenderSettings getRenderSettings() {
		return render;
	}

	public ControlSettings getControlSettings() {
		return control;
	}
	
}
