package window;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * In charge of opening and closing windows.
 * @author David Cosby
 */
public class WindowManager {
	ProjectWindow projectWindow = new ProjectWindow();
	final String stylesPre = "styles/";
	
	public WindowManager() {
		setSkin("gruvbox.css");
	}
	
	/**
	 * @param stylesName cssFileName Name of the stylesheet to be applied
	 */
	public void setSkin(String stylesName) {
		projectWindow.addCSS(stylesPre + stylesName);
	}
	
	
	public ProjectWindow getProjectWindow() {
		return projectWindow;
	}
	
	/**
	 * enables visibility for the ProjectWindow.
	 */
	public void showProjectWindow() {
		projectWindow.show();
	}
	/**
	 * disables visibility for the ProjectWindow.
	 */
	public void hideProjectWindow() {
		projectWindow.hide();
	}

}
