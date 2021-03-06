package ui;

import bridge.Bridge;
import bridge.Tools;
import javafx.scene.control.*;

/**
 * Lets the user equip MouseTools.
 * @author David Cosby
 */
public class Toolbar extends ToolBar {
	ToggleButton pan = new ToggleButton("Pan");
	ToggleButton create = new ToggleButton("Create");
	ToggleButton delete = new ToggleButton("Delete");


	ToggleGroup mouseTools = new ToggleGroup();
	
	public Toolbar() {
		build();
		setupUserInput();
	}
	
	/**
	 * sets up GUI layouts and element properties
	 */
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
	
	/**
	 * Listens for button input to equip and unequip MouseTools
	 */
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
