package mouseTools;

import javafx.scene.input.*;
import vector.Vector;
import planets.render.Camera;
import bridge.Bridge;
import projectData.*;
import ui.SimulationPane;


public class Dragger extends MouseTool {
	private Vector initPos;
	private Vector currentPos = new Vector();
	private Vector lastPos = new Vector();
	private Camera camera = Bridge.getProjectData().getCamera();
	private ControlSettings controls = Bridge.getProjectData().getSettings().getControlSettings();
	private MouseButton panButton = controls.getMouseButtonForEvent("CameraPan");
	private SimulationPane simulationPane = Bridge.getRenderer().getSimulationPane();

	
	public Dragger() {

	}
	
	private boolean isPanEvent(MouseEvent m) {
		return m.getButton().equals(panButton);
	}
	
	private void updateLastPosWithEventInfo(MouseEvent e) {
		lastPos = new Vector(e.getX(), e.getY());
	}
	
	private Vector getScreenSize() {
		return new Vector(simulationPane.getWidth(), simulationPane.getHeight());
	}
	
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
			updateLastPosWithEventInfo(e);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		if (isPanEvent(e)) {
			Vector currentPos = new Vector(e.getX(), e.getY());
			Vector delta = lastPos.sub(currentPos);
			delta = camera.getVectorDisplacementFromPixelDisplacement(delta);

			pan(delta);
			//camera.setOffset(camera.getOffset().add(newOffset));
			
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
	
	private void zoom(double deltaRatio, Vector zoomCenter) {
		//Vector screenSize = getScreenSize();
		double zoomBefore = camera.getZoom();
		double newZoom = zoomBefore * deltaRatio;
		//camera.setZoom(newZoom);

		Vector screenCenter = getScreenCenter();
		Vector zoomCenterRelative = screenCenter.sub(zoomCenter);
		System.out.println(camera.getScreenDisplacementFromCenter(zoomCenterRelative));
		
		double previousZoomFactor = 1 - (zoomBefore - newZoom);
		Vector previousRelative = zoomCenterRelative.mul(previousZoomFactor);
		
		Vector offset = zoomCenterRelative.sub(previousRelative);

		offset = camera.getVectorDisplacementFromPixelDisplacement(offset.mul(1));
		//System.out.println(offset);
		
		//camera.setOffset(camera.getOffset().add(offset));


	}
	
	

	
}
