package ui.drawer;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class DataDrawer extends Drawer {
	
	VBox sections = new VBox(10);
	
	HBox nameSection = new HBox(10);
	Label nameLabel = new Label("Name");
	TextField name = new TextField("");
	
	HBox massSection = new HBox(10);
	Label massLabel = new Label("Mass\t");
	TextField mass = new TextField("");
	Label massUnit = new Label("kg");
	
	HBox radiusSection = new HBox(10);
	Label radiusLabel = new Label("Radius\t");
	TextField radius = new TextField("");
	Label radiusUnit = new Label("km");
	
	HBox densitySection = new HBox(10);
	Label densityLabel = new Label("Density\t");
	TextField density = new TextField("");
	Label densityUnit = new Label("g/cm^3");


	
	public DataDrawer() {
		super("Planet Data");
		build();
	}
	
	private void build() {
		
		name.setPrefWidth(150);
		nameSection.getStyleClass().add("section");
		nameSection.getChildren().addAll(nameLabel, name);
		
		mass.setPrefWidth(75);
		massSection.getStyleClass().add("section");
		massSection.getChildren().addAll(massLabel, mass, massUnit);
		
		radius.setPrefWidth(75);
		radiusSection.getStyleClass().add("section");
		radiusSection.getChildren().addAll(radiusLabel, radius, radiusUnit);
		
		density.setPrefWidth(50);
		densitySection.getStyleClass().add("section");
		densitySection.getChildren().addAll(densityLabel, density, densityUnit);
		
		sections.getChildren().addAll(nameSection, massSection, radiusSection, densitySection);
		getContent().getChildren().addAll(sections);

	}
	
	public void setNameTo(String newName) {
		name.setText(newName);
	}
	
	public void setMassTo(double newMass) {
		mass.setText(newMass + "");
	}
	
	public void setRadiusTo(double newRadius) {
		radius.setText(newRadius + "");
	}
	
	public void setDensityTo(double newDensity) {
		density.setText(newDensity + "");
	}
	
	public void setOpenForChanges(boolean open) {
		name.setEditable(open);
		mass.setEditable(open);
		radius.setEditable(open);
		density.setEditable(open);
	}

}
