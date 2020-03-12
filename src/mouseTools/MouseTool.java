package mouseTools;

import javafx.scene.input.InputEvent;

public abstract class MouseTool {

	public abstract void onMouseDown(InputEvent e);
	public abstract void onMouseUp(InputEvent e);
	public abstract void onMouseMove(InputEvent e);
	
}
