package ui.drawer;

import planets.physics.physicsObjects.Planet;
import ui.SimulationPane;
import bridge.Bridge;
import javafx.scene.input.*;


public class DrawerController {

	private Planet currentPlanet;
	public DataDrawer data;
	private boolean listening = false;
	
	
	public DrawerController() {
	}
	
	private boolean isSubmitKey(KeyEvent e) {
		return (e.getCode() == KeyCode.ENTER) || (e.getCode() == KeyCode.TAB);
	}
	
	
	private void listenForUserInput() {
		listening = true;
		
		data.name.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				currentPlanet.setName(data.name.getText());
				data.mass.requestFocus();
			}
		});
		
		data.mass.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double massAsDouble = Double.parseDouble(data.mass.getText());
					currentPlanet.setMass(massAsDouble);
					data.radius.setText(currentPlanet.getRadius() + "");
				}
				catch (Exception ex) {
					data.mass.setText("" + currentPlanet.getMass());
				}
				data.density.requestFocus();
			}
		});
		
		data.density.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double densityAsDouble = Double.parseDouble(data.density.getText());
					currentPlanet.setDensity(densityAsDouble);
					data.radius.setText(currentPlanet.getRadius() + "");
				}
				catch (Exception ex) {
					data.density.setText("" + currentPlanet.getDensity());
				}
				data.requestFocus();
			}
		});
		

		
	}
	
	public void selectedPlanet(Planet p) {
		currentPlanet = p;
		updateOneTimePlanetInformation();
		
		if (Bridge.getProjectData().getSettings().getPhysicsSettings().getPlaying() == true) {
			data.setOpenForChanges(false);
		}
		else {
			data.setOpenForChanges(true);
		}
	}
	
	public void deselectedPlanet() {
		currentPlanet = null;
		data.setNameTo("");
		data.setMassTo(0);
		data.setRadiusTo(0);
		data.setDensityTo(0);
		data.setOpenForChanges(false);
	}
	
	
	private void updateOneTimePlanetInformation() {
		data = Bridge.getWindowManager().getProjectWindow().getPropertiesPane().getDataDrawer();
		if (!listening) {
			listenForUserInput();
		}
		data.setNameTo(currentPlanet.getName());
		data.setMassTo(currentPlanet.getMass());
		data.setRadiusTo(currentPlanet.getRadius());
		data.setDensityTo(currentPlanet.getDensity());
	}
	
	public void setOpenForChanges(boolean open) {
		if (currentPlanet != null) {
			data.setOpenForChanges(open);
		}
	}
	
	public void updateRealtimePlanetInformation() {
		
	}
	
}
