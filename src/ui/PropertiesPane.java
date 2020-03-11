package ui;

import javafx.scene.layout.*;
import ui.drawer.*;


public class PropertiesPane extends Pane {
	VBox drawer = new VBox();
	Drawer data = new DataDrawer();
	Drawer physics = new PhysicsDrawer();
	Drawer render = new RenderDrawer();

	
	public PropertiesPane() {
		build();
	}
	
	private void build() {
		setId("properties");
		setMaxWidth(420);
		setMinWidth(125);
		data.minWidthProperty().bind(this.widthProperty());
		physics.minWidthProperty().bind(this.widthProperty());
		render.minWidthProperty().bind(this.widthProperty());
		
		data.setExpanded(true);
		physics.setExpanded(false);
		render.setExpanded(false);

		
		drawer.getChildren().addAll(data, physics, render);
		getChildren().add(drawer);
	}

}
