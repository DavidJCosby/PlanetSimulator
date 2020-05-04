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

	/**
	 * Fires when a mouse button is pressed somewhere in the SimulationPane.
	 * @param e MouseEvent passed from the MouseDown action.
	 */
	public abstract void onMouseDown(MouseEvent e);
	/**
	 * Fires when a mouse button is released somewhere in the SimulationPane.
	 * @param e MouseEvent passed from the MouseUp action.
	 */
	public abstract void onMouseUp(MouseEvent e);
	/**
	 * Fires when a mouse is moved somewhere in the SimulationPane.
	 * @param e MouseEvent passed from the MouseMove action.
	 */
	public abstract void onMouseMove(MouseEvent e);
	/**
	 * @param e ScrollEvent passed from the MouseScroll action.
	 */
	public abstract void onScroll(ScrollEvent e);
	/**
	 * Fires whenever the tool is equipped.
	 */
	public abstract void onEquip();
	/**
	 * Fires whenever the tool is unequipped.
	 */
	public abstract void onUnequip();
	
}
