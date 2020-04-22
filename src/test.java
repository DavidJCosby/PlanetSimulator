import projectData.ProjectData;

import mouseTools.*;
import scheduler.*;
import planets.PlanetManager;
import planets.physics.PhysicsEngine;
import planets.physics.physicsObjects.Planet;
import planets.render.*;
import planets.render.renderObjects.*;
import vector.Vector;
import bridge.Bridge;
import bridge.Tools;
import window.*;

import java.util.concurrent.*;

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
		
		Bridge.getProjectData().setCurrentTool(Tools.DRAG);
		windowManager.getProjectWindow().getPropertiesPane().getController().selectedPlanet(Tools.CREATE.getDefaultPlanet());
		
	}
	
	private void setStyle(String styleName) {
		Bridge.getWindowManager().getProjectWindow().scene.getStylesheets().clear();
		Bridge.getWindowManager().getProjectWindow().scene.getStylesheets().add("styles/" + styleName+ ".css");
		System.out.println("applied " + styleName);
	}
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException {
		setupBridge();
		Bridge.getWindowManager().showProjectWindow();
		setStyle("gruvbox");

	
		Planet p1 = new Planet();
		p1.setName("Earth");
		p1.setPosition(new Vector(0, 0));
		p1.setMass(5.972e24);
		p1.setDensity(5.51);
		Bridge.getPlanetManager().registerPlanet(p1);
		
		Planet p2 = new Planet();
		p2.setName("Moon");
		p2.setPosition(new Vector(384400, 0));
		p2.setMass(7.348e22);
		p2.setVelocity(new Vector(0, -1.07));
		//p2.setVelocity(new Vector(0, -32190));
		Bridge.getPlanetManager().registerPlanet(p2);

		
		Runnable renderTask = () -> {
			try {
				Bridge.getPhysicsEngine().calculate();
				Bridge.getRenderer().render();
			}
			catch (Exception e) {
				System.out.print("error");
			}
		};
		
		Scheduler scheduler = Bridge.getScheduler();
		
		scheduler.start(renderTask, 90);
	}
	
	@Override
	public void stop() {
		Bridge.getScheduler().stop();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}