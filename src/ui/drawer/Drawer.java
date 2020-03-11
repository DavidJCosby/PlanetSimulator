package ui.drawer;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Drawer extends HBox {
	private Pane content = new Pane();
	private TitledPane drawer;
	
	public Drawer(String title) {
		createDrawer(title);
		build();
	}
	
	private void createDrawer(String title) {
		drawer = new TitledPane(title, content);
	}
	
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
	
	public void setExpanded(boolean expandedState) {
		drawer.setExpanded(expandedState);
	}
	
}
