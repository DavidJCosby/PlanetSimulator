package window;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * In charge of opening and closing windows.
 * @author David Cosby
 */
public class WindowManager {
	ProjectWindow projectWindow = new ProjectWindow();
	
	public WindowManager() {

	}
	
	public ProjectWindow getProjectWindow() {
		return projectWindow;
	}
	
	public void showProjectWindow() {
		projectWindow.show();
	}
	
	public void hideProjectWindow() {
		projectWindow.hide();
	}

}
