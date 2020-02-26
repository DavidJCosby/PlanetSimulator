import java.util.TimerTask;
import java.util.Date;

class TimerExample extends TimerTask {
	private String name ;
	private final int MAX_TARDINESS = 3;
	public TimerExample(String n){
		this.name=n;
	}

	@Override
	public void run() {
		
		 if (System.currentTimeMillis() - scheduledExecutionTime() >= MAX_TARDINESS) {
			System.out.println("skipping task.\n\n");
			ExecuteTimer.lastUnix = new Date().getTime();
			return;  // Too late; skip this execution.
		}
		else {		
			Date now = new Date();
			long time = now.getTime();
			

			double fps = (1000/(time-ExecuteTimer.lastUnix));
			ExecuteTimer.avg = ((ExecuteTimer.avg*9) + fps) / (10);
			ExecuteTimer.records++;
			

			
			System.out.println(ExecuteTimer.avg);
			ExecuteTimer.lastUnix = time;
			
			try {
				//Thread.sleep(33);
			} catch (Exception e) {
				
			}
		}
	}
}