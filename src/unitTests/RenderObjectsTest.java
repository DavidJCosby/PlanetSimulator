package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import vector.Vector;

import org.junit.jupiter.api.Test;

import planets.render.renderObjects.*;
import ui.SimulationPane;

class RenderObjectsTest {

	// RenderObject.java
	private void compareVectors(Vector a, Vector b) {
		assertEquals(a.getX(), b.getX(), 0.000001);
		assertEquals(a.getY(), b.getY(), 0.000001);
	}
	
	@Test
	void testConstruction() {
		PlanetDisplay obj = new PlanetDisplay(32);
		assertNotNull(obj);
	}
	
	@Test
	void testPosition() {
		PlanetDisplay obj = new PlanetDisplay(17);
		obj.setPosition(new Vector(18, 32));
		compareVectors(new Vector(18, 32), obj.getPosition());
	}
	
	@Test
	void testIdentification() {
		PlanetDisplay obj = new PlanetDisplay(2);
		assertEquals(2, obj.getID());
		obj.setID(83);
		assertEquals(83, obj.getID());
	}
	
	// RenderObjectContainer.java
	@Test
	void testContainerConstruction() {
		PlanetDisplayContainer cont = new PlanetDisplayContainer();
		assertNotNull(cont);
	}
	
	@Test
	void testRegistration() {
		PlanetDisplayContainer cont = new PlanetDisplayContainer();
		PlanetDisplay obj1 = new PlanetDisplay(8);
		PlanetDisplay obj2 = new PlanetDisplay(9);
		
		cont.addPlanetDisplay(obj1);
		assertEquals(1, cont.getNumberOfPlanetDisplays());
		
		cont.addPlanetDisplay(obj2);
		assertEquals(2, cont.getNumberOfPlanetDisplays());
		
		assertSame(obj1, cont.getPlanetDisplayByIndex(0));
		assertSame(obj2, cont.getPlanetDisplayByID(9));
	}
	
	// SimulationPane.java
	@Test
	void testSimPaneConstruction() {
		SimulationPane simPane = new SimulationPane();
		assertNotNull(simPane);
	}
	
	@Test
	void testAddPlanetDisplay() {
		SimulationPane simPane = new SimulationPane();
		PlanetDisplay rObj = new PlanetDisplay(22);
		simPane.addPlanetDisplay(rObj);
		assertSame(rObj, simPane.getPlanetDisplays().getChildren().get(0));
	}
	
	@Test
	void testClip() { // just kinda bugging me in the coverage chart, sorry.
		SimulationPane simPane = new SimulationPane();
		simPane.resize(1234, 567);
	}

}
