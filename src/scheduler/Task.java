package scheduler;

/**
 * Extends TimerTask to implement maxTardiness, which represents how late a task may be running before it must be skipped.
 * @author David Cosby
 */
public class Task extends java.util.TimerTask {
	private final int MAX_TARDINESS;
	
	
	public Task(int maxTardiness) {
		MAX_TARDINESS = maxTardiness;
	}
	
	public void performTask() { // to be overridden by by sub-tasks
		
	}
	
	@Override 
	public void run() {
		if (System.currentTimeMillis() - scheduledExecutionTime() > MAX_TARDINESS) {
			System.out.println("Dropped task");
			return;  // Too late; skip this execution.
		}
		else {
			long before = System.currentTimeMillis();
			performTask();
			long after = System.currentTimeMillis();
			//System.out.println("\tTask took " + (after-before) + "ms");
		}
	}
	
}
