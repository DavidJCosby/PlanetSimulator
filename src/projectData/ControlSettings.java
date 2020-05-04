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
		mouseBindings.put("CameraPan", MouseButton.PRIMARY);
	}
	
	/**
	 * @param eventName what type of mouse event we are looking for.
	 * @return MouseButton that must be pressed for the event to be recognized.
	 */
	public MouseButton getMouseButtonForEvent(String eventName) {
		return mouseBindings.get(eventName);
	}
	
}
