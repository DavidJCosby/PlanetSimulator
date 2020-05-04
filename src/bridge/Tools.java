package bridge;

import javafx.scene.control.ToggleButton;
import mouseTools.*;

/**
 * An Enum of the three types of the MouseTools that can be used in the simulation.
 * @author David Cosby
 */
public class Tools {
	public static Dragger DRAG = new Dragger();
	public static Creator CREATE = new Creator();
	public static Deleter DELETE = new Deleter();
	}
