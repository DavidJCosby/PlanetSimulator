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
	
	public void start(Runnable task, double frequency) {
		int period = (int)(1e6 / frequency); // measured in microseconds for better timing.
		System.out.println(period);
		executor.scheduleAtFixedRate(task, 0, period, TimeUnit.MICROSECONDS);
	}
	
	public void stop() {
		executor.shutdown();
	}
}
