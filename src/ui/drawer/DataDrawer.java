package ui.drawer;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import vector.Vector;


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

	VBox positionSection = new VBox(10);
	VBox posVecSection = new VBox(10);
	HBox vecX = new HBox(10);
	HBox vecY = new HBox(10);
	HBox positionTitle = new HBox(10);
	Label positionLabel = new Label("Position");
	Label xLabel = new Label("     X");
	Label yLabel = new Label("     Y");
	TextField x = new TextField("");
	TextField y = new TextField("");
	Label positionUnit = new Label("km");
	Label positionUnit2 = new Label("km");
	
	VBox velocitySection = new VBox(10);
	VBox velVecSection = new VBox(10);
	HBox vecVX = new HBox(10);
	HBox vecVY = new HBox(10);
	HBox velocityTitle = new HBox(10);
	Label velocityLabel = new Label("Velocity");
	Label vxLabel = new Label("     X");
	Label vyLabel = new Label("     Y");
	TextField vx = new TextField("");
	TextField vy = new TextField("");
	Label velocityUnit = new Label("km/s");
	Label velocityUnit2 = new Label("km/s");

	
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
		
		x.setPrefWidth(85);
		y.setPrefWidth(85);
		positionSection.getStyleClass().add("section");
		positionSection.getChildren().addAll(positionTitle, posVecSection);
		posVecSection.getChildren().addAll(vecX, vecY);
		positionTitle.getChildren().addAll(positionLabel);
		vecX.getChildren().addAll(xLabel, x, positionUnit);
		vecY.getChildren().addAll(yLabel, y, positionUnit2);
		
		vx.setPrefWidth(85);
		vy.setPrefWidth(85);
		velocitySection.getStyleClass().add("section");
		velocitySection.getChildren().addAll(velocityTitle, velVecSection);
		velVecSection.getChildren().addAll(vecVX, vecVY);
		velocityTitle.getChildren().addAll(velocityLabel);
		vecVX.getChildren().addAll(vxLabel, vx, velocityUnit);
		vecVY.getChildren().addAll(vyLabel, vy, velocityUnit2);
		
		sections.getChildren().addAll(nameSection, massSection, densitySection, radiusSection, positionSection, velocitySection);
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
	
	public void setPositionTo(Vector newPosition) {
		if (x.isEditable()) {
		double xPos = newPosition.getX();
		double yPos = newPosition.getY();
		double accuracy = 1e2;
		xPos = Math.round(xPos * accuracy) / accuracy;
		yPos = Math.round(yPos * accuracy) / accuracy;

		x.setText(xPos + "");
		y.setText(yPos + "");
		}
		else {
			x.setText("---------------");
			y.setText("---------------");
		}
	}
	
	public void setVelocityTo(Vector newVelocity) {
		if (vx.isEditable()) {
			double xVel = newVelocity.getX();
			double yVel = newVelocity.getY();
			double accuracy = 1e3;
			xVel = Math.round(xVel * accuracy) / accuracy;
			yVel = Math.round(yVel * accuracy) / accuracy;
	
			vx.setText(xVel + "");
			vy.setText(yVel + "");
		}
		else {
			vx.setText("---------------");
			vy.setText("---------------");
		}
	}
	
	public void setOpenForChanges(boolean open) {
		name.setEditable(open);
		mass.setEditable(open);
		radius.setEditable(false);
		density.setEditable(open);
		x.setEditable(open);
		y.setEditable(open);
		vx.setEditable(open);
		vy.setEditable(open);
	}
	
	
}

