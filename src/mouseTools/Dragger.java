package mouseTools;

import javafx.scene.input.InputEvent;


public class Dragger extends MouseTool {

	public Dragger() {
		
	}
	
	public void onMouseDown(InputEvent e) {
		System.out.println(e);
	}
	
	public void onMouseUp(InputEvent e) {
		System.out.println(e);

	}
	
	public void onMouseMove(InputEvent e) {
		System.out.println(e);

	}
	
}
