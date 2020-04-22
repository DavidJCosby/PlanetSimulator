package mouseTools;

import javafx.scene.input.*;

/**
 * Abstract definition for mouse tools. When a MouseTool is equipped, it needs to respond to the following signals:
 * 	OnMouseDown();
 *  OnMouseUp();
 *  OnMouseMove();
 *  onScroll();
 * @author David Cosby
 */
public abstract class MouseTool {

	public abstract void onMouseDown(MouseEvent e);
	public abstract void onMouseUp(MouseEvent e);
	public abstract void onMouseMove(MouseEvent e);
	public abstract void onScroll(ScrollEvent e);
	public abstract void onEquip();
	public abstract void onUnequip();
	
}
