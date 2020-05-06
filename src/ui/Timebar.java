package ui;

import javafx.scene.layout.*;
import bridge.Bridge;
import javafx.geometry.*;
import javafx.scene.control.*;

import projectData.PhysicsSettings;


/**
 * Bar in charge of modulating the speed of the simulation.
 * @author David Cosby
 */

public class Timebar extends BorderPane {
	HBox buttonGroup = new HBox();
	/**
	 * pauses or plays the simulation.
	 */
	Button play = new Button("||");
	/**
	 * halves the speed of the simulation
	 */
	Button slower = new Button("0.5");
	/**
	 * doubles the speed of the simulation
	 */
	Button faster = new Button("x 2");
	
	PhysicsSettings settings = Bridge.getProjectData().getSettings().getPhysicsSettings();
	
	
	public Timebar() {
		build();
		connectButtons();
	}
	
	/**
	 * sets up GUI layouts and element properties
	 */
	private void build() {
		setId("timebar");		
		setPrefHeight(73);
		setCenter(buttonGroup);
		buttonGroup.setMaxWidth(170);
		Insets padding = new Insets(5, 0, 15, 15);
		HBox.setMargin(slower, padding);
		HBox.setMargin(play, padding);
		HBox.setMargin(faster, padding);

		buttonGroup.getChildren().addAll(slower, play, faster);
	}
	
	/**
	 * Creates lambdas for the slower, faster, and play buttons, allowing the user to manipulate time.
	 */
	private void connectButtons() {
		slower.setOnAction((event) -> {
			settings.setSimulationSpeedScale(settings.getSimulationSpeedScale() * 0.5);
		});
	
		play.setOnAction((event) -> {
			boolean playing = settings.getPlaying();
			if (playing == false) {
				play.setText("||");
				settings.setPlaying(true);
			}
			else {
				play.setText(">");
				settings.setPlaying(false);
			}
		});
		
		faster.setOnAction((event) -> {
			settings.setSimulationSpeedScale(settings.getSimulationSpeedScale() * 2.0);
		});
	}
	
}
