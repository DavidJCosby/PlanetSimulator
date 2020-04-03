package scheduler;

import bridge.Bridge;

public class RenderTask extends SchedulerTask {
	
	public RenderTask(double frequency) {
		super(frequency);
	}
	
	@Override
	public void performTask() {
		Bridge.getPhysicsEngine().calculate();
		Bridge.getRenderer().render();
	}
}
