package scheduler;

import java.util.*;
import java.util.concurrent.*;

/**
 * Lets a task repeat at regular intervals in the background.
 * @author David Cosby
 */
public class Scheduler {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	
	
	public Scheduler() {
		
	}
	
	/**
	 * @param task Runnable to be executed at regular intervals.
	 * @param frequency How many times each second does the task need to be executed.
	 */
	public void start(Runnable task, double frequency) {
		int period = (int)(1e6 / frequency); // measured in microseconds for better timing.
		System.out.println(period);
		executor.scheduleAtFixedRate(task, 0, period, TimeUnit.MICROSECONDS);
	}
	
	/**
	 * Stops all tasks.
	 */
	public void stop() {
		executor.shutdown();
	}
}
