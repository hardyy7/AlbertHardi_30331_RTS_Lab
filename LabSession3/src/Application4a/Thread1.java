package Application4a;

public class Thread1 extends Thread{
	
	Integer p6Monitor;
	int activity_min, activity_max;
	Thread0 t0;
	public Thread1(Integer p6Monitor, int activity_min, int activity_max, Thread0 t0) {
		this.p6Monitor = p6Monitor;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
		this.t0 = t0;
	}
	
	public void run() {
		try {
			System.out.println("Thread1 - STATE 1");
			synchronized(p6Monitor) {
					p6Monitor.wait();
			}
			System.out.println("Thread1 - STATE 2");
			int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
			System.out.println("Thread1 does activity for: " + k);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
			System.out.println("Thread1 - STATE 3");
			if(t0!=null) {
				t0.join();
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
