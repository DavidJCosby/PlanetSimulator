import physicsObject.Planet;
import render.*;
import scene.SimulationScene;
import vector.Vector;
import bridge.Bridge;

public class test {

	
	public static void main(String[] args) {
		SimulationScene scene = new SimulationScene();
		Bridge.setScene(scene);
		Renderer renderer = new Renderer();
		Bridge.setRenderer(renderer);
		System.out.println("ran");
	}
}