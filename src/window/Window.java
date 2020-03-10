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
	public Scene scene = new Scene(contents, 1280, 720);
	
	
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
	
	public void addCSS(String cssFileName) {
		scene.getStylesheets().add(cssFileName);
	}
}
