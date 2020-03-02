package ui;
import javafx.scene.control.*;

public class Topbar extends MenuBar {
	
	Menu fileMenu = new Menu("File");
	MenuItem save = new MenuItem("Save");
	
	public Topbar() {
		super();
		buildMenus();
	}
	
	private void buildMenus() {
		//useSystemMenuBarProperty().set(true);
		fileMenu.getItems().addAll(save);
		getMenus().add(fileMenu);
	}

}
