package bridge;

import projectData.ProjectData;
import window.WindowManager;
import scheduler.Scheduler;
import planetManager.PlanetManager;
import planets.physics.PhysicsEngine;
import planets.render.Renderer;

/**
 * Static reference point for high level components.
 * @author David Cosby
 */
public class Bridge {
	private static ProjectData projectData;
	private static Renderer renderer;
	private static WindowManager windowManager;
	private static Scheduler scheduler;
	private static PhysicsEngine physicsEngine;
	private static PlanetManager planetManager;
	//public static Scheduler scheduler;
	//public static UI ui;
	
	
	public static ProjectData getProjectData() {
		return projectData;
	}
	
	public static void setProjectData(ProjectData newProjectData) {
		projectData = newProjectData;
	}
	
	public static Renderer getRenderer() {
		return renderer;
	}
	
	public static void setRenderer(Renderer newRenderer) {
		renderer = newRenderer;
	}
	
	public static WindowManager getWindowManager() {
		return windowManager;
	}
	
	public static void setWindowManager(WindowManager newWindowManager) {
		windowManager = newWindowManager;
	}
	
	public static void setScheduler(Scheduler newScheduler) {
		scheduler = newScheduler;
	}
	
	public static Scheduler getScheduler() {
		return scheduler;
	}
	
	public static void setPhysicsEngine(PhysicsEngine newPhyiscsEngine) {
		physicsEngine = newPhyiscsEngine;
	}
	
	public static PhysicsEngine getPhysicsEngine() {
		return physicsEngine;
	}
	
	public static void setPlanetManager(PlanetManager newPlanetManager) {
		planetManager = newPlanetManager;
	}
	
	public static PlanetManager getPlanetManager() {
		return planetManager;
	}
}
