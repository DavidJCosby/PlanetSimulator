package scheduler;

/**
 * Extends TimerTask to implement maxTardiness, which represents how late a task may be running before it must be skipped.
 * @author David Cosby
 */
public class SchedulerTask {
	private double frequency;
	
	
	public SchedulerTask(double freq) {
		frequency = freq;
	}
	
	public void setFrequency(double newFrequency) {
		frequency = newFrequency;
	}
	
	public double getFrequency() {
		return frequency;
	}
	
	protected void performTask() { // to be overriden by sub-tasks
		
	}
	
	/**
	 * @return int - how much time in ms the task took to execute
	 */
	public int run() { // to be overridden by by sub-tasks
		long start = System.currentTimeMillis();
		performTask();
		long end = System.currentTimeMillis();
		return (int)(end-start);
	}
	

	
}
