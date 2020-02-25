package bridge;

import projectData.ProjectData;
import render.Renderer;
import window.WindowManager;

/**
 * @author David Cosby
 *
 */
public class Bridge {
	private static ProjectData scene;
	private static Renderer renderer;
	private static WindowManager windowManager;
	//public static Scheduler scheduler;
	//public static UI ui;
	
	
	public static ProjectData getProjectData() {
		return scene;
	}
	
	public static void setProjectData(ProjectData newProjectData) {
		scene = newProjectData;
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
