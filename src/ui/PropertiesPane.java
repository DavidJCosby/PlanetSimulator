package ui;

import javafx.scene.layout.*;
import ui.drawer.*;


/**
 * Left-side pane in charge of adjusting object properties and simulation settings.
 * @author David Cosby
 */
public class PropertiesPane extends Pane {
	VBox drawer = new VBox();
	DataDrawer data = new DataDrawer();
	PhysicsDrawer physics = new PhysicsDrawer();
	RenderDrawer render = new RenderDrawer();
	DrawerController controller = new DrawerController();

	
	public PropertiesPane() {
		build();
	}
	
	/**
	 * sets up GUI layouts and element properties
	 */
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
	
	public DataDrawer getDataDrawer() {
		return data;
	}
	
	public PhysicsDrawer getPhysicsDrawer() {
		return physics;
	}
	
	public RenderDrawer getRenderDrawer() {
		return render;
	}
	
	public DrawerController getController() {
		return controller;
	}

}
