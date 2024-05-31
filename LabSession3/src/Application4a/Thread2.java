package Application4a;

public class Thread2 extends Thread{
	Thread0 t0;
	Integer p10Monitor;
	int activity_min, activity_max;
	public Thread2(Integer p10Monitor,int activity_min, int activity_max, Thread0 t0) {
		this.p10Monitor = p10Monitor;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
		this.t0 = t0;
	}
	
	public void run() {
		try {
			System.out.println("Thread2 - STATE 1");
			synchronized(p10Monitor) {
					p10Monitor.wait();
			}
			System.out.println("Thread2 - STATE 2");
			int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
			System.out.println("Thread2 does activity for: " + k);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
			System.out.println("Thread2 - STATE 3");
			if(t0!=null) {
				t0.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
