package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.Tools;
import planets.physics.PhysicsEngine;
import planets.physics.physicsObjects.*;
import planets.render.Renderer;
import projectData.ProjectData;
import scheduler.Scheduler;
import planets.PlanetManager;

import vector.Vector;
import window.WindowManager;

/**
 * Test physics objects for correctness.
 * @author David Cosby
 */
class PhysicsObjectTest {

	private void compareVectors(Vector a, Vector b) {
		assertEquals(a.getX(), b.getX(), 0.000001);
		assertEquals(a.getY(), b.getY(), 0.000001);
	}
	
	@Test
	void testConstruction() {
		Planet p = new Planet(new Vector(50000, -60022));
		compareVectors(p.getPosition(), new Vector(50000, -60022));
		
		p = new Planet(new Vector(6, 1), 4.20e69, 6.9);
		compareVectors(new Vector(6,1), p.getPosition());
		assertEquals(4.20e69, p.getMass());
		assertEquals(6.9, p.getDensity());
	}
	
	@Test
	void testPosition() {
		Planet p = new Planet();
		p.setPosition(new Vector(40, -2));
		compareVectors(new Vector(40, -2), p.getPosition());
	}
	
	@Test
	void testMass() {
		Planet p = new Planet(new Vector(), 20, 5);
		p.setMass(8e-3);
		assertEquals(8e-3, p.getMass());
	}
	
	@Test
	void testDensity() {
		Planet p = new Planet(new Vector(), 20, 5);
		p.setDensity(3.14);
		assertEquals(3.14, p.getDensity());
	}
	
	@Test
	void testVelocity() {
		Planet p = new Planet();
		p.setVelocity(new Vector(0, -2));
		compareVectors(new Vector(0, -2), p.getVelocity());
		
		p.addVelocity(new Vector(3, 3));
		compareVectors(new Vector(3, 1), p.getVelocity());
	}
	
	@Test
	void testMomentum() {
		Planet p = new Planet(new Vector(), 60, 2);
		p.setVelocity(new Vector(2, -3));
		compareVectors(new Vector( 120, -180), p.getMomentum());
		
		p.applyMomentum(new Vector(-84, 22));
		compareVectors(new Vector(36, -158), p.getMomentum());
	}
	
	@Test
	void testRadius() {
		Planet p = new Planet(new Vector(), 7.34767309E22, 3.34); // moon parameters
		assertEquals(1738.22, p.getRadius(), 0.01);
	}
	
	@Test
	void testVolume() {
		Planet p = new Planet(new Vector(), 7.34767309E22, 3.34); // moon parameters
		assertEquals(2.1999E10, p.getVolume(), 3e4);
	}
	
	@Test
	void testIdentification() {
		int expected = Planet.getPlanetsEverCreated() + 1;
		Planet p = new Planet();
		assertEquals(expected, p.getID());
	}
	
	@Test
	void testName() {
		Planet p = new Planet();
		p.setName("NATHAN");
		assertEquals("NATHAN", p.getName());
	}
	
	@Test
	void testPlanetContainer() {
		PlanetContainer c = new PlanetContainer();
		Planet p = new Planet();
		c.addPlanet(p);
		assertSame(c.getPlanetByIndex(0), c.getPlanetById(p.getID()));
		assertEquals(1, c.getNumberOfPlanets());
	}
	
	@Test
	void testBridge() {
		// just run some setup code to see if it works, only way I can think of to test it.
		ProjectData data = new ProjectData();
		Bridge.setProjectData(data);
		
		Renderer renderer = new Renderer();
		Bridge.setRenderer(renderer);

		Scheduler scheduler = new Scheduler();
		Bridge.setScheduler(scheduler);
		
		PhysicsEngine physicsEngine = new PhysicsEngine();
		Bridge.setPhysicsEngine(physicsEngine);
		
		PlanetManager planetManager = new PlanetManager();
		Bridge.setPlanetManager(planetManager);
		
		Bridge.getProjectData().setCurrentTool(Tools.DRAG);
		
		// no way to test the PlanetManager.
	}
}
