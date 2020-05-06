package ui;
import javafx.scene.control.*;

/**
 * Basic topbar containing features like save, open, new, exit.
 * Not fully implemented.
 * @author David Cosby
 */
public class Topbar extends MenuBar {
	
	Menu fileMenu = new Menu("File");
	MenuItem save = new MenuItem("Save");
	MenuItem exit = new MenuItem("Exit");
	
	
	public Topbar() {
		super();
		buildMenus();
	}
	
	/**
	 * sets up GUI layouts and element properties
	 */
	private void buildMenus() {
		//useSystemMenuBarProperty().set(true);
		fileMenu.getItems().addAll(save, exit);
		getMenus().add(fileMenu);
	}

}
