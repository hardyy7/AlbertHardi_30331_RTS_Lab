package Application2;

public class Thread1 extends Thread{

	private Integer p9Monitor;
	private Integer p10Monitor;
	private int sleep, activity_min, activity_max;
	private int activity1_min, activity1_max;
	int valid;
	
	public Thread1(Integer p9Monitor,Integer p10Monitor, int sleep, int activity_min,int activity_max,
			int activity1_min, int activity1_max) {
		this.p9Monitor = p9Monitor;
	    this.p10Monitor = p10Monitor;
	    this.sleep = sleep;
	    this.activity_min = activity_min;
	    this.activity_max = activity_max;
	    this.activity1_min = activity1_min;
	    this.activity1_max = activity1_max;
	}
	
	public void run() {
		System.out.println("Thread1 - STATE 1");
		int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
		System.out.println("Thread1 does activity for: " + k);
		for(int i = 0; i < k * 100000; i++) {
			i++;
			i--;
		}
		try {
			
				synchronized(p10Monitor) {
				System.out.println("Thread1 - STATE 2");
				int k1 = (int) Math.round(Math.random()*(activity1_max-activity1_min)+activity1_min);
				System.out.println("Thread1 does activity for: " + k1);
				for(int i = 0; i < k * 100000; i++) {
					i++;
					i--;
				}
				}
				synchronized(p9Monitor) {
					System.out.println("Thread1 - STATE 3");
					Thread.sleep(sleep*500);
				}
				System.out.println("Thread1 - STATE 4");
			
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}