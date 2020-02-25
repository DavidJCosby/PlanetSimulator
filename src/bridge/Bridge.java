package bridge;

import projectData.ProjectData;
import render.Renderer;

/**
 * @author David Cosby
 *
 */
public class Bridge {
	private static ProjectData scene;
	private static Renderer renderer;
	//public static Scheduler scheduler;
	//public static UI ui;
	
	
	public static ProjectData getScene() {
		return scene;
	}
	
	public static void setScene(ProjectData newScene) {
		scene = newScene;
	}
	
	public static Renderer getRenderer() {
		return renderer;
	}
	
	public static void setRenderer(Renderer newRenderer) {
		renderer = newRenderer;
	}
	
}
