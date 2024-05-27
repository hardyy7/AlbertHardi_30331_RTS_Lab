package L4A2;

import java.util.concurrent.locks.Lock;

public class Thread0 extends Thread{
	private int sleep, activity_min, activity_max;
	private int activity1_min, activity1_max;
	Lock p9,p10;
	
	Thread0(int s, int am, int aM, int am1, int aM1, Lock l1, Lock l2){
		this.sleep = s;
		this.activity_min = am;
		this.activity_max = aM;
		this.activity1_min = am1;
		this.activity1_max = aM1;
		this.p9 = l1;
		this.p10 = l2;
	}
	
	public void run() {
		System.out.println("Thread0 - STATE 1");
		int k = (int) Math.round(Math.random()*(activity_max-activity_min)+activity_min);
		System.out.println("Thread0 does activity for: " + k);
		for(int i = 0; i < k * 100000; i++) {
			i++;
			i--;
		}
		if(p9.tryLock()) {
			try {
			System.out.println("Thread0 - STATE 2");
			int k1 = (int) Math.round(Math.random()*(activity1_max-activity1_min)+activity1_min);
			System.out.println("Thread0 does activity for: " + k1);
			for(int i = 0; i < k * 100000; i++) {
				i++;
				i--;
			}
			if(p10.tryLock()) {
				try {
				System.out.println("Thread0 - STATE 3");
				try {
					Thread.sleep(sleep*500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}finally {
				p10.unlock();
				}
			}
			
			}finally {
				p9.unlock();
			}
		}
		System.out.println("Thread0 - STATE 4");
	}
}
