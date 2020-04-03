package scheduler;

import java.util.*;
import java.util.concurrent.*;

public class Scheduler {
	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	
	public Scheduler() {
		
	}
	
	
	
	public void start(Runnable task, double frequency) {
		int period = (int)(1e6 / frequency);
		System.out.println(period);
		executor.scheduleAtFixedRate(task, 1000000, period, TimeUnit.MICROSECONDS);
	}
	
	
	public void stop() {
		executor.shutdown();
	}
}
