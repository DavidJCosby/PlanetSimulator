package bridge;

import scene.SimulationScene;
import render.Renderer;

/**
 * @author David Cosby
 *
 */
public class Bridge {
	private static SimulationScene scene;
	private static Renderer renderer;
	//public static Scheduler scheduler;
	//public static UI ui;
	
	
	public static SimulationScene getScene() {
		return scene;
	}
	
	public static void setScene(SimulationScene newScene) {
		scene = newScene;
	}
	
	public static Renderer getRenderer() {
		return renderer;
	}
	
	public static void setRenderer(Renderer newRenderer) {
		renderer = newRenderer;
	}
	
}
