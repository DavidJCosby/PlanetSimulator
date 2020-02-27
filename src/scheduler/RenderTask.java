package scheduler;

import bridge.Bridge;

public class RenderTask extends Task {
	
	public RenderTask(int maxTardiness) {
		super(maxTardiness);
	}
	
	@Override
	public void performTask() {
		Bridge.getPhysicsEngine().calculate();
		Bridge.getRenderer().render();
	}
}
