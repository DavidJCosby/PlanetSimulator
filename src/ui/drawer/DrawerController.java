package ui.drawer;

import planets.physics.physicsObjects.Planet;
import vector.Vector;
import ui.SimulationPane;
import bridge.Bridge;
import bridge.Tools;
import javafx.scene.input.*;
import bridge.*;

/**
 * Processes user input on drawers, updates fields with correct information.
 * @author David Cosby
 */
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
		

		data.x.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double xAsDouble = Double.parseDouble(data.x.getText());
					currentPlanet.setPosition(new Vector(xAsDouble, currentPlanet.getPosition().getY()));
				}
				catch (Exception ex) {
					data.setPositionTo(currentPlanet.getPosition());
				}
				data.requestFocus();
			}
		});
		
		data.y.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double yAsDouble = Double.parseDouble(data.y.getText());
					currentPlanet.setPosition(new Vector(currentPlanet.getPosition().getX(), yAsDouble));
				}
				catch (Exception ex) {
					data.setPositionTo(currentPlanet.getPosition());
				}
				data.requestFocus();
			}
		});
		
		data.vx.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double vxAsDouble = Double.parseDouble(data.vx.getText());
					currentPlanet.setVelocity(new Vector(vxAsDouble, currentPlanet.getVelocity().getY()));
				}
				catch (Exception ex) {
					data.setVelocityTo(currentPlanet.getVelocity());
				}
				data.requestFocus();
			}
		});
		
		data.vy.setOnKeyPressed((e) -> {
			if (isSubmitKey(e) && data.name.isEditable()) {
				try {
					double vyAsDouble = Double.parseDouble(data.vy.getText());
					currentPlanet.setVelocity(new Vector(currentPlanet.getVelocity().getX(), vyAsDouble));

				}
				catch (Exception ex) {
					data.setVelocityTo(currentPlanet.getVelocity());
				}
				data.requestFocus();
			}
		});
	}
	
	/**
	 * @param p Planet that was selected
	 */
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
	
	/**
	 * Fire this when we need to set planet selection to null.
	 */
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
		data.setPositionTo(currentPlanet.getPosition());
		data.setVelocityTo(currentPlanet.getVelocity());

	}
	
	/**
	 * @param open whether we are open for changes or not.
	 */
	public void setOpenForChanges(boolean open) {
		if (currentPlanet != null) {
			data.setOpenForChanges(open);
			data.setVelocityTo(currentPlanet.getVelocity());
			data.setPositionTo(currentPlanet.getPosition());
		}
	}
	
}
