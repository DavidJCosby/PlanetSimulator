package ui;

import javafx.scene.layout.*;
import bridge.Bridge;
import javafx.geometry.*;
import javafx.scene.control.*;

import projectData.PhysicsSettings;


public class Timebar extends BorderPane {
	HBox buttonGroup = new HBox();
	Button play = new Button("||");
	Button slower = new Button("0.5");
	Button faster = new Button("x 2");
	PhysicsSettings settings = Bridge.getProjectData().getSettings().getPhysicsSettings();
	
	
	public Timebar() {
		setId("timebar");		
		build();
		connectButtons();
	}
	
	private void build() {
		setPrefHeight(73);
		setCenter(buttonGroup);
		buttonGroup.setMaxWidth(170);
		Insets padding = new Insets(5, 0, 15, 15);
		HBox.setMargin(slower, padding);
		HBox.setMargin(play, padding);
		HBox.setMargin(faster, padding);

		buttonGroup.getChildren().addAll(slower, play, faster);
	}
	
	private void connectButtons() {
		slower.setOnAction((event) -> {
			settings.setSimulationSpeedScale(settings.getSimulationSpeedScale() * 0.5);
		});
	
		play.setOnAction((event) -> {
			boolean playing = settings.getPlaying();
			if (playing == true) {
				play.setText("||");
				settings.setPlaying(false);
			}
			else {
				play.setText(">");
				settings.setPlaying(true);
			}
		});
		
		faster.setOnAction((event) -> {
			settings.setSimulationSpeedScale(settings.getSimulationSpeedScale() * 2.0);
		});
	}
	
}
