package unitTests;

import static org.junit.jupiter.api.Assertions.*;
import projectData.*;
import mouseTools.*;
import planets.physics.physicsObjects.*;

import org.junit.jupiter.api.Test;

class ProjectDataTest {

	@Test
	void test() {
		ProjectData data = new ProjectData();
		
		assertTrue(data.getPlanets() != null);
		assertTrue(data.getSettings() != null);
		assertTrue(data.getSettings().getControlSettings() != null);
		assertTrue(data.getSettings().getPhysicsSettings() != null);
		assertTrue(data.getSettings().getRenderSettings() != null);	
		
		Planet p = new Planet();
		data.setSelection(p);

		assertEquals(p, data.getSelection());
		


	}

}
