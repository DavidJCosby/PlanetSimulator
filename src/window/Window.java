package window;

/**
 * @author David Cosby
 *
 */

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.stage.*;


public class Window extends Stage {
	private Group contents = new Group();
	protected Scene scene = new Scene(contents, 300, 300, Color.web("#002b36"));
	
	
	public Window() {
		super(StageStyle.DECORATED);
		setupScene();
	}
	
	private void setupScene() {
		setScene(scene);
	}
	
	public Group getContents() {
		return contents;
	}
	
	public void setContents(Group newContents) {
		contents = newContents;
	}
}
