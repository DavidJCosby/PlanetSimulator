package scheduler;

import bridge.Bridge;

public class HelloWorldTask extends SchedulerTask {
	
	public HelloWorldTask(double frequency) {
		super(frequency);
	}
	
	@Override
	public void performTask() {
		System.out.println("Hello world");
	}
}
