package ui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.Group;

public class DataDrawer extends HBox {
	private Pane defaultContent = new Pane();
	private TitledPane drawer = new TitledPane("Data", defaultContent);
	
	public DataDrawer() {
		build();
	}
	
	private void build() {
		HBox.setHgrow(drawer, Priority.ALWAYS);
		setPadding(new Insets(4, 4, 4, 4));
		getChildren().add(drawer);
		drawer.setExpanded(true);
		drawer.setAnimated(false);
		drawer.setContent(defaultContent);
	}
	
}
