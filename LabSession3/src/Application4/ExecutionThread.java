package Application4;

public class ExecutionThread extends Thread{
	
	Integer monitor;
	int activity_min, activity_max;
	public ExecutionThread(Integer monitor, int activity_min, int activity_max) {
		this.monitor = monitor;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
	}
	
	public void run() {
		System.out.println(this.getName() + " - STATE 1");
		int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
		System.out.println(this.getName() + " does activity for: " + k);
		for(int i = 0; i < k * 100000; i++) {
			i++;
			i--;
		}
		System.out.println(this.getName() + " - STATE 2");
	}
	
}
