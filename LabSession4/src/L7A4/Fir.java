package L7A4;

import java.util.concurrent.Semaphore;

public class Fir extends Thread{

	int sleep, activity_min, activity_max;
	Semaphore s;
	int permit;
	int name;
	public Fir(int name,int sleep, int activity_min, int activity_max,int perm, Semaphore sa) {
		this.name = name;
		this.sleep = sleep;
		this.activity_min = activity_min;
		this.activity_max = activity_max;
		this.permit = perm;
		this.s = sa;
	}
	
	public void run() {
		try {
			while(true) {
				System.out.println("Fir " + name +  " - STATE 1");
				this.s.acquire(this.permit);
					System.out.println("Fir "+ name + " took a token from the semaphore");
					System.out.println("Fir "+ name + " - STATE 2");
					int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
					for(int i = 0; i < k * 100000; i++) {
						i++;
						i--;
					}
				this.s.release();
				System.out.println("Fir "+ name + "released a token from the semaphore");
				System.out.println("Fir " + name + " - STATE 3");
				Thread.sleep(sleep*500);
				System.out.println("Fir " + name + " - STATE 4");
			}
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
