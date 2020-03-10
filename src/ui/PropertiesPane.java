package ui;

import javafx.scene.layout.*;


public class PropertiesPane extends Pane {
	VBox drawer = new VBox();
	DataDrawer data = new DataDrawer();
	
	public PropertiesPane() {
		build();
	}
	
	private void build() {
		setId("properties");
		setMaxWidth(400);
		getChildren().addAll(data);
		data.minWidthProperty().bind(this.widthProperty());
	}

}
