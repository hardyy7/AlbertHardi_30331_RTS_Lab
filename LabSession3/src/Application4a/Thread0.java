package Application4a;

public class Thread0 extends Thread{

	Integer p6Monitor;
	Integer p10Monitor;
	int sleep, activity_min, activity_max;
	public Thread0(Integer p6Monitor, Integer p10Monitor, int sleep, int activity_min, int activity_max) {
		this.p6Monitor = p6Monitor;
		this.p10Monitor = p10Monitor;
		this.sleep = sleep;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
	}
	
	public void run() {
		try {
			System.out.println("Thread0 - STATE 1");
			System.out.println("Thread0 sleeps for " + sleep);
			Thread.sleep(sleep*500);
			System.out.println("Thread0 - STATE 2");
			int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
			System.out.println("Thread0 does activity for: " + k);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
			synchronized(p6Monitor) {
				p6Monitor.notify();
			}
			synchronized(p10Monitor) {
				p10Monitor.notify();
			}
			System.out.println("Thread0 - STATE 3");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
