package ui.drawer;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

/**
 * Bare-bones drawer
 * @author David Cosby
 */
public class Drawer extends HBox {
	private Pane content = new Pane();
	private TitledPane drawer;
	
	public Drawer(String title) {
		createDrawer(title);
		build();
	}
	
	/**
	 * @param title Title applied to th TitledPane that forms the drawer.
	 */
	private void createDrawer(String title) {
		drawer = new TitledPane(title, content);
	}
	
	/**
	 * sets up GUI layouts and element properties
	 */
	private void build() {
		HBox.setHgrow(drawer, Priority.ALWAYS);
		setPadding(new Insets(4, 4, 4, 4));
		getChildren().add(drawer);
		drawer.setExpanded(true);
		drawer.setAnimated(false);
		drawer.setContent(content);
	}
	
	protected Pane getContent() {
		return content;
	}
	
	/**
	 * @param expandedState boolean indicating whether the drawer should be expanded or not.
	 */
	public void setExpanded(boolean expandedState) {
		drawer.setExpanded(expandedState);
	}
	
}
