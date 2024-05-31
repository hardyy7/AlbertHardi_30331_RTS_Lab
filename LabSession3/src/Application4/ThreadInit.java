package Application4;

public class ThreadInit extends Thread{
	
	Integer monitor = new Integer(1);
	int sleep, activity_min, activity_max;
	public ThreadInit(int sleep, int activity_min, int activity_max) {
		this.sleep = sleep;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
	}
	
	public void run() {
		try {
			System.out.println("ThreadInit sleeps for " + sleep);
			Thread.sleep(sleep*500);
			System.out.println("ThreadInit - STATE 1");
			int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
			System.out.println("ThreadInit does activity for: " + k);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
			new ExecutionThread(monitor, 3, 5).start();
			new ExecutionThread(monitor, 4, 6).start();
			System.out.println("ThreadInit - STATE 2");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
