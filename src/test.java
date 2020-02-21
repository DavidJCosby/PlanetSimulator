import physicsObject.Planet;
import render.Camera;
import scene.Scene;
import vector.Vector;

public class test {

	
	public static void main(String[] args) {
		Camera cam = new Camera();
		Vector loc = new Vector(0, 100);
		System.out.println(cam.getScreenDisplacementFromCenter(loc));
	}
}