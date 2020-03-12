package projectData;

import javafx.event.*;
import javafx.scene.input.*;
import java.util.HashMap;

/**
 * Settings specific to the User Input.
 * @author David Cosby
 */
public class ControlSettings {
	HashMap<String, MouseButton> mouseBindings = new HashMap<String, MouseButton>();
	
	public ControlSettings() {
		setup();
	}
	
	private void setup() {
		mouseBindings.put("CameraPan", MouseButton.MIDDLE);
	}

	
	public MouseButton getMouseButtonForEvent(String eventName) {
		return mouseBindings.get(eventName);
	}
	
}
