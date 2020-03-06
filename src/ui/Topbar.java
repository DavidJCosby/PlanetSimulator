package ui;
import javafx.scene.control.*;

public class Topbar extends MenuBar {
	
	Menu fileMenu = new Menu("File");
	MenuItem save = new MenuItem("Save");
	MenuItem exit = new MenuItem("Exit");
	
	
	
	public Topbar() {
		super();
		buildMenus();
	}
	
	private void buildMenus() {
		//useSystemMenuBarProperty().set(true);
		fileMenu.getItems().addAll(save, exit);
		getMenus().add(fileMenu);
	}

}
