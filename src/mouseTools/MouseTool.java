package mouseTools;

import javafx.scene.input.*;

public abstract class MouseTool {

	public abstract void onMouseDown(MouseEvent e);
	public abstract void onMouseUp(MouseEvent e);
	public abstract void onMouseMove(MouseEvent e);
	public abstract void onScroll(ScrollEvent e);
	
}
