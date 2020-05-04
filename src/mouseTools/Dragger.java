package mouseTools;

import javafx.scene.input.*;
import vector.Vector;
import planets.render.Camera;
import bridge.*;
import projectData.*;
import ui.SimulationPane;

/**
 * Dragger MouseTool in charge of camera movement and planet selection.
 * @author David Cosby
 */

public class Dragger extends MouseTool {
	private Vector initPos;
	private Vector currentPos = new Vector();
	private Vector lastPos = new Vector();
	private Camera camera = Bridge.getProjectData().getCamera();
	private ControlSettings controls = Bridge.getProjectData().getSettings().getControlSettings();
	private MouseButton panButton = controls.getMouseButtonForEvent("CameraPan");
	private SimulationPane simulationPane = Bridge.getRenderer().getSimulationPane();
	private Creator creator = Tools.CREATE;

	
	public Dragger() {

	}
	
	/**
	 * @param m MouseEvent to be tested
	 * @return boolean indicating whether the mouse event had the pan button down.
	 */
	/**
	 * @param m MouseEvent to be checked
	 * @return boolean indicating whether the event should be used for panning by checking which mouse button was down.
	 */
	private boolean isPanEvent(MouseEvent m) {
		return m.getButton().equals(panButton);
	}
	
	private void updateLastPosWithEventInfo(MouseEvent e) {
		lastPos = new Vector(e.getX(), e.getY());
	}
	
	/**
	 * @return Vector with dimensions equal to the SimulationPane's Width and Height.
	 */
	private Vector getScreenSize() {
		return new Vector(simulationPane.getWidth(), simulationPane.getHeight());
	}
	
	/**
	 * @return Vector representing the SimulationPane's center position.
	 */
	private Vector getScreenCenter() {
		return getScreenSize().mul(0.5);
	}
	

	public void onMouseDown(MouseEvent e) {
		if (isPanEvent(e)) {
			initPos = new Vector(e.getX(), e.getY());
			updateLastPosWithEventInfo(e);
		}
	}
	
	public void onMouseUp(MouseEvent e) {
		if (isPanEvent(e)) {
			if (e.getTarget().equals(simulationPane)) {
				if (lastPos.sub(initPos).magnitude() < 10) {
					Bridge.getProjectData().setSelection(null);
					
					Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getController().selectedPlanet(Tools.CREATE.getDefaultPlanet());

				}
			}
			updateLastPosWithEventInfo(e);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		if (isPanEvent(e)) {
			Vector currentPos = new Vector(e.getX(), e.getY());
			Vector delta = lastPos.sub(currentPos);
			delta = camera.getVectorDisplacementFromPixelDisplacement(delta);
			pan(delta);			
			updateLastPosWithEventInfo(e);
		}
	}
	
	private void pan(Vector deltaVector) {
		camera.setOffset(camera.getOffset().add(deltaVector));
	}
	
	public void onScroll(ScrollEvent e) {
		double deltaX = e.getDeltaY(); //* e.getMultiplierY();
		double zoomFactor = (1.0 + (deltaX / simulationPane.getHeight() * 1));
	
		Vector mousePosition = new Vector(e.getX(), e.getY());
		
		zoom(zoomFactor, mousePosition);
	}
	
	public void onEquip() {
		
	}
	
	public void onUnequip() {
		
	}
	
	
	private void zoom(double deltaRatio, Vector zoomCenter) {
		zoomCenter = camera.getVectorDisplacementFromPixelDisplacement(zoomCenter);
		Vector screenCenter = getScreenCenter();
		
		screenCenter = camera.getVectorDisplacementFromPixelDisplacement(screenCenter);
		
		double zoomBefore = camera.getZoom();
		double newZoom = zoomBefore * deltaRatio;
		camera.setZoom(newZoom);

		Vector zoomCenterRelative = screenCenter.sub(zoomCenter);
		
		double previousZoomFactor = 1 - (zoomBefore - newZoom);
		Vector previousRelative = zoomCenterRelative.mul(previousZoomFactor);
		
		Vector offset = zoomCenterRelative.sub(previousRelative).div(newZoom);

		camera.setOffset(camera.getOffset().add(offset));
	}

	
}
