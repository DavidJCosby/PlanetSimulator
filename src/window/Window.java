package window;

import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.stage.*;
/**
 * Barebones window.
 * @author David Cosby
 */
public class Window extends Stage {
	private Group contents = new Group();
	public Scene scene = new Scene(contents, 1440, 900);
	
	
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
