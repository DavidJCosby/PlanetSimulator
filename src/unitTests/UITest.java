package unitTests;

import static org.junit.jupiter.api.Assertions.*;
import window.*;


import org.junit.jupiter.api.Test;

import ui.*;
import ui.drawer.*;

class UITest {

	@Test
	void testConstruction() {
		// not sure why, but I can't seem to construct UI elements in a test Environment.
		// my guess is that either it doesn't like me using listeners setting up user input lambdas.
		
		SimulationPane tpbr = new SimulationPane();
		// but for some reason this one is okay?
	}

}
