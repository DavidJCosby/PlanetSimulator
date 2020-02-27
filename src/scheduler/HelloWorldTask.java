package scheduler;

public class HelloWorldTask extends Task {
	
	public HelloWorldTask(int maxTardiness) {
		super(maxTardiness);
	}
	
	@Override
	public void performTask() {
		System.out.println("Hello World");
	}
}
