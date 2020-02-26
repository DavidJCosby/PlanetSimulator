package bridge;

import projectData.ProjectData;
import render.Renderer;
import window.WindowManager;

/**
 * Static reference point for high level components.
 * @author David Cosby
 */
public class Bridge {
	private static ProjectData projectData;
	private static Renderer renderer;
	private static WindowManager windowManager;
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
}
