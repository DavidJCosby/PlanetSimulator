package mouseTools;

import javafx.scene.input.*;
import vector.Vector;
import planets.render.Camera;
import bridge.Bridge;
import projectData.*;
import ui.SimulationPane;


public class Dragger extends MouseTool {
	private Vector initPos;
	private Vector currentPos;
	private Vector offsetMemory = new Vector();
	private Camera camera = Bridge.getProjectData().getCamera();
	private ControlSettings controls = Bridge.getProjectData().getSettings().getControlSettings();
	private MouseButton panButton = controls.getMouseButtonForEvent("CameraPan");
	private SimulationPane simulationPane = Bridge.getRenderer().getSimulationPane();

	public Dragger() {

	}
	
	private boolean isPanEvent(MouseEvent m) {
		return m.getButton().equals(panButton);
	}
	
	public void onMouseDown(MouseEvent e) {
		if (isPanEvent(e)) {
			initPos = new Vector(e.getX(), e.getY());
		}
	}
	
	public void onMouseUp(MouseEvent e) {
		if (isPanEvent(e)) {
			offsetMemory = offsetMemory.add(initPos.sub(currentPos));
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		if (isPanEvent(e)) {
			currentPos = new Vector(e.getX(), e.getY());
			Vector delta = initPos.add(offsetMemory).sub(currentPos);
			Vector newOffset = camera.getVectorDisplacementFromPixelDisplacement(delta);
			camera.setOffset(newOffset);
		}
	}
	
	private Vector getScreenCenter() {
		return new Vector(simulationPane.getWidth() / 2, simulationPane.getHeight() / 2);
	}
	
	public void onScroll(ScrollEvent e) {
		double deltaX = e.getDeltaY(); //* e.getMultiplierY();
		double zoomFactor = (1.0 + (deltaX / simulationPane.getHeight() * 0.1));
		double newZoom = camera.getZoom() * zoomFactor;
	
		Vector screenCenter = getScreenCenter();
		Vector mousePosition = new Vector(e.getX(), e.getY());
		Vector distFromCenter = screenCenter.sub(mousePosition);
		
		double fac = 1;
		if (Math.signum(deltaX) != 1) {
			fac = 0;
		}
		
		System.out.println(fac);
		Vector distScaled = distFromCenter.mul(-zoomFactor * fac);
		
		offsetMemory = offsetMemory.sub(distScaled);
		
		camera.setZoom(newZoom);
		camera.setOffset(camera.getOffset().add(distScaled));
	//	camera.setOffset(distScaled);
		
	
		
		//camera.setOffset(translatedOffset);
		
	}
	
}
