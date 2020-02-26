import java.util.Timer;
import java.util.Timer;

public class ExecuteTimer {
	public static long lastUnix = 0;
	public static double avg = 60;
	public static int records = 1;
	
	public static void main(String[] args){
		TimerExample te1=new TimerExample("calculatePhysics");
		TimerExample te2=new TimerExample("render");

		Timer t=new Timer();
		t.scheduleAtFixedRate(te2, 0, 8);
	}

}
