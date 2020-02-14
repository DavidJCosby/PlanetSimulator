package scenes;

/**
 * @author David Cosby
 *
 */
public class Settings {
	private PhysicsSettings physics = new PhysicsSettings();
	private RenderSettings render = new RenderSettings();
	
	public Settings() {
		
	}

	public PhysicsSettings getPhysicsSettings() {
		return physics;
	}
	
	public RenderSettings getRenderSettings() {
		return render;
	}

}
