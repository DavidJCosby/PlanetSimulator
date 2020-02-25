import physicsObject.Planet;
import projectData.ProjectData;
import render.*;
import vector.Vector;
import bridge.Bridge;

public class test {

	
	public static void main(String[] args) {
		ProjectData scene = new ProjectData();
		Bridge.setScene(scene);
		Renderer renderer = new Renderer();
		Bridge.setRenderer(renderer);
		System.out.println("ran");
	}
}