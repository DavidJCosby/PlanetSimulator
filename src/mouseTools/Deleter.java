package mouseTools;

import bridge.Bridge;
import bridge.Tools;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import planets.physics.physicsObjects.*;
import ui.SimulationPane;
import vector.Vector;
import planets.render.Camera;
import planets.render.renderObjects.*;

public class Deleter extends MouseTool {
	
	private Vector lastPos;
	
	public Deleter() {

	}
	
	
	public void onMouseDown(MouseEvent e) {
		if (e.getTarget() instanceof PlanetDisplay) {
			PlanetDisplay pd = (PlanetDisplay)e.getTarget();
			Bridge.getPlanetManager().removePlanetById(pd.getID());
		}
	}
	public void onMouseUp(MouseEvent e) {
		
		
	}
	public void onMouseMove(MouseEvent e) {
		lastPos = new Vector(e.getX(), e.getY());
		
	}
	public void onScroll(ScrollEvent e) {
		Tools.DRAG.onScroll(e);
	}
	
	public void onEquip() {
		
	}
	
	public void onUnequip() {
		
	}	
}
