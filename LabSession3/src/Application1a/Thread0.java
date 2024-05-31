package Application1a;

public class Thread0 extends Thread {
	Integer P9monitor;
	int sleep, activity_min, activity_max;
	public Thread0(Integer P9monitor, int sleep, int activity_min, int activity_max) {
		this.P9monitor = P9monitor;
		this.sleep = sleep;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
	}
	
	public void run() {
		System.out.println(this.getName() + " - STATE 1");
		synchronized (P9monitor) {
			System.out.println(this.getName() + " - STATE 2");
			int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
			System.out.println(this.getName() + " does activity for: " + k);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
		
			System.out.println(this.getName() + " waits for: " + sleep);
			try {
				Thread.sleep(sleep*500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(this.getName() + " - STATE 3");
	}
}
