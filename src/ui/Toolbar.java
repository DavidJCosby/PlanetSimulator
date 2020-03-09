package ui;

import javafx.scene.control.*;

public class Toolbar extends ToolBar {
	ToggleButton dragger = new ToggleButton("Drag");
	ToggleButton creator = new ToggleButton("Create");

	ToggleGroup mouseTools = new ToggleGroup();
	
	public Toolbar() {
		build();
	}
	
	private void build() {
		creator.setSelected(true);
		dragger.setToggleGroup(mouseTools);
		creator.setToggleGroup(mouseTools);
		getItems().addAll(dragger, creator);
	}
	
}
