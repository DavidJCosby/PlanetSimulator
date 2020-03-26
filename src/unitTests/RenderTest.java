package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import planets.render.*;
import planets.render.renderObjects.PlanetDisplayContainer;
import vector.Vector;


class RenderTest {

	private void compareVectors(Vector a, Vector b) {
		assertEquals(a.getX(), b.getX(), 0.000001);
		assertEquals(a.getY(), b.getY(), 0.000001);
	}

	// Camera.java
	@Test
	void testCameraConstruction() {
		Camera cam = new Camera();
		assertNotNull(cam);
		
		Camera cam2 = new Camera(new Vector(5, -3));
		assertNotNull(cam2);
		compareVectors(new Vector(5, -3), cam2.getPosition());
	}
	
	@Test
	void testPosAndOffset() {
		Camera cam = new Camera();
		
		cam.setPosition(new Vector(33, 22));
		compareVectors(new Vector(33, 22), cam.getPosition());
		
		cam.setOffset(new Vector(3.2, 1));
		compareVectors(new Vector(3.2, 1), cam.getOffset());
	}
	
	@Test
	void testZoom() {
		Camera cam = new Camera();
		
		cam.setZoom(0.3);
		assertEquals(0.3, cam.getZoom());
		
		assertEquals(6.0, cam.getScreenPixelLength(20));
		
		compareVectors(new Vector(72, -9), cam.getScreenDisplacementFromCenter(new Vector(240, -30)));
	
		assertEquals(20, cam.getVectorLengthFromPixelLength(6));
		
		compareVectors(new Vector(240, -30), cam.getVectorDisplacementFromPixelDisplacement(new Vector(72, -9)));

	}
	
	// Renderer.java
	
	@Test
	void testRendererConstruction() {
		Renderer renderer = new Renderer();
		assertNotNull(renderer);
	}
	
	@Test
	void testPlanetDisplayContainerRetrieval() {
		Renderer renderer = new Renderer();
		assertTrue(renderer.getPlanetDisplayContainer() instanceof PlanetDisplayContainer);
	}

}
