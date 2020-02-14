import scenes.Scene;
import planets.Planet;
import vectors.Vector;


public class test {

	
	public static void main(String[] args) {
		Scene newScene = new Scene();
		Vector a = new Vector(1,2);
		Vector b = new Vector(3,4);
		
		System.out.println(a.add(b));
	}
}