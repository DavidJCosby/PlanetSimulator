import projectData.ProjectData;
import scheduler.*;
import planets.PlanetManager;
import planets.physics.PhysicsEngine;
import planets.physics.physicsObjects.Planet;
import planets.render.*;
import planets.render.renderObjects.*;
import vector.Vector;
import bridge.Bridge;
import window.*;

import javafx.application.Application;
import javafx.stage.Stage;

public class test extends Application {
	
	private void setupBridge() {
		ProjectData data = new ProjectData();
		Bridge.setProjectData(data);
		
		Renderer renderer = new Renderer();
		Bridge.setRenderer(renderer);

		WindowManager windowManager = new WindowManager();
		Bridge.setWindowManager(windowManager);
		
		Scheduler scheduler = new Scheduler();
		Bridge.setScheduler(scheduler);
		
		PhysicsEngine physicsEngine = new PhysicsEngine();
		Bridge.setPhysicsEngine(physicsEngine);
		
		PlanetManager planetManager = new PlanetManager();
		Bridge.setPlanetManager(planetManager);
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		setupBridge();
		Bridge.getWindowManager().showProjectWindow();
		
		Planet p2 = new Planet();
		p2.setPosition(new Vector(0, 0));
		p2.setMass(6.9e20);
		p2.setVelocity(new Vector(100, 200));
		Bridge.getPlanetManager().registerPlanet(p2);
		
		
		Scheduler epic = Bridge.getScheduler();
		Task task = new RenderTask(6);
		epic.scheduleRegularTask("Render", task, 30);
	}
	
	@Override
	public void stop() {
		Bridge.getScheduler().stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}