package ui;

import javafx.scene.control.*;

public class Toolbar extends ToolBar {
	ToggleButton pan = new ToggleButton("Pan");
	ToggleButton create = new ToggleButton("Create");
	ToggleButton delete = new ToggleButton("Delete");


	ToggleGroup mouseTools = new ToggleGroup();
	
	public Toolbar() {
		build();
	}
	
	private void build() {
		create.setSelected(true);
		pan.setFocusTraversable(false);
		create.setFocusTraversable(false);
		delete.setFocusTraversable(false);

		pan.setToggleGroup(mouseTools);
		create.setToggleGroup(mouseTools);
		delete.setToggleGroup(mouseTools);
		getItems().addAll(pan, create, delete);
		
		
	}
	
}
