package projectData;

import planets.physics.physicsObjects.*;

import mouseTools.MouseTool;
import planets.render.Camera;


/**
 * Contains only data relating to the project that needs to be saved and loaded.
 * @author David Cosby
*/
public class ProjectData {
	private PlanetContainer planets = new PlanetContainer();
	private Settings settings = new Settings();
	private static MouseTool currentTool; 
	private Camera camera = new Camera();
	private Planet selection;
	
	public ProjectData() {
		
	}


	public PlanetContainer getPlanets() { 
		return planets;
	}
	
	public Settings getSettings() {
		return settings;
	}
	
	public Camera getCamera() {
		return camera;
	}
	
	public MouseTool getCurrentTool() {
		return currentTool;
	}
	
	public void setCurrentTool(MouseTool tool) {
		currentTool = tool;
	}
	
	public Planet getSelection() {
		return selection;
	}
	
	public void setSelection(Planet newSelection) {
		selection = newSelection;
	}
	
}
