package scheduler;

public class TaskData {
	private Task task;
	private double frequency;
	
	public TaskData(String name, Task task, double frequency) {
		this.task = task;
		this.frequency = frequency;
	}
	
	public Task getTask() {
		return task;
	}


	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double newFrequency) {
		frequency = newFrequency;
	}
}
