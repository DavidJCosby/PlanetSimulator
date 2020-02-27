package scheduler;

import java.util.*;


public class Scheduler {
	private HashMap<String, TaskData> tasks = new HashMap<String, TaskData>();
	
	Timer timer = new Timer();
	
	public Scheduler() {
		
	}
	
	private void startRunningTask(TaskData taskData) {
		int period = (int)(1000 / taskData.getFrequency());
		timer.scheduleAtFixedRate(taskData.getTask(), 0, period);
	}
	
	public void scheduleRegularTask(String name, Task task, double frequency) {
		TaskData taskData = new TaskData(name, task, frequency);
		tasks.put(name, taskData);
		startRunningTask(taskData);
	}
	
	public void stop() {
		timer.cancel();
		timer.purge();
	}
	
}
