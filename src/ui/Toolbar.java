package ui;

import bridge.Bridge;
import bridge.Tools;
import javafx.scene.control.*;

public class Toolbar extends ToolBar {
	ToggleButton pan = new ToggleButton("Pan");
	ToggleButton create = new ToggleButton("Create");
	ToggleButton delete = new ToggleButton("Delete");


	ToggleGroup mouseTools = new ToggleGroup();
	
	public Toolbar() {
		build();
		setupUserInput();
	}
	
	private void build() {
		pan.setSelected(true);
		pan.setFocusTraversable(false);
		create.setFocusTraversable(false);
		delete.setFocusTraversable(false);

		pan.setToggleGroup(mouseTools);
		create.setToggleGroup(mouseTools);
		delete.setToggleGroup(mouseTools);
		getItems().addAll(pan, create, delete);
		
	}
	
	private void setupUserInput() {
		pan.setOnAction((e) -> {
			Bridge.getProjectData().getCurrentTool().onUnequip();
			Bridge.getProjectData().setCurrentTool(Tools.DRAG);
			Tools.DRAG.onEquip();
		});
		
		create.setOnAction((e) -> {
			Bridge.getProjectData().getCurrentTool().onUnequip();
			Bridge.getProjectData().setCurrentTool(Tools.CREATE);
			Tools.CREATE.onEquip();
		});
		
		delete.setOnAction((e)-> {
			Bridge.getProjectData().getCurrentTool().onUnequip();
			Bridge.getProjectData().setCurrentTool(Tools.DELETE);
			Tools.DELETE.onEquip();

		});
	}
	
}
