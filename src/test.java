import physicsObject.Planet;
import projectData.ProjectData;
import render.*;
import render.renderObjects.*;
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
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		setupBridge();
		Bridge.getWindowManager().showProjectWindow();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}