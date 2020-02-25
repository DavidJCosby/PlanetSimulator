package unitTests;

import static org.junit.jupiter.api.Assertions.*;
import render.renderObjects.*;
import vector.Vector;

import org.junit.jupiter.api.Test;

class RenderObjectsTest {

	// RenderObject.java
	private void compareVectors(Vector a, Vector b) {
		assertEquals(a.getX(), b.getX(), 0.000001);
		assertEquals(a.getY(), b.getY(), 0.000001);
	}
	
	@Test
	void testConstruction() {
		RenderObject obj = new RenderObject(32);
		assertNotNull(obj);
	}
	
	@Test
	void testPosition() {
		RenderObject obj = new RenderObject(17);
		obj.setPosition(new Vector(18, 32));
		compareVectors(new Vector(18, 32), obj.getPosition());
	}
	
	@Test
	void testIdentification() {
		RenderObject obj = new RenderObject(2);
		assertEquals(2, obj.getID());
		obj.setID(83);
		assertEquals(83, obj.getID());
	}
	
	// RenderObjectContainer.java
	@Test
	void testContainerConstruction() {
		RenderObjectContainer cont = new RenderObjectContainer();
		assertNotNull(cont);
	}
	
	@Test
	void testRegistration() {
		RenderObjectContainer cont = new RenderObjectContainer();
		RenderObject obj1 = new RenderObject(8);
		RenderObject obj2 = new RenderObject(9);
		
		cont.addRenderObject(obj1);
		assertEquals(1, cont.getNumberOfRenderObjects());
		
		cont.addRenderObject(obj2);
		assertEquals(2, cont.getNumberOfRenderObjects());
		
		assertSame(obj1, cont.getRenderObjectByIndex(0));
		assertSame(obj2, cont.getRenderObjectByID(9));
	}

}
