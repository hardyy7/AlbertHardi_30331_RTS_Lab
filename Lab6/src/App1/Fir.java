package App1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir extends Thread{
	
	Semaphore s9, s10;
	CyclicBarrier barrier;
	int name, activity_min,activity_max,activity_min1,activity_max1,delay,permit;
	
	Fir(int n, Semaphore s9, Semaphore s10, CyclicBarrier barrier, int delay, int permit, 
			int a_min, int a_max, int a_min1, int a_max1){
		this.name = n;
		this.s9 = s9;
		this.s10 = s10;
		this.barrier = barrier;
		this.delay = delay;
		this.permit = permit;
		this.activity_min = a_min;
		this.activity_max = a_max;
        this.activity_min1 = a_min1;
        this.activity_max1 = a_max1;
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println(name + "- State 1");
				int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
				for(int i = 0; i < k * 100000; i++) {
					i++;
					i--;
				}
				this.s9.acquire(this.permit);
				System.out.println(name + "- Aquired a token from Semaphore 9");
				System.out.println(name + "- State 2");
				k = (int) Math.round(Math.random() * (activity_max1 - activity_min1) + activity_min1);
				for(int i = 0; i < k * 100000; i++) {
					i++;
					i--;
				}
				this.s10.acquire(this.permit);
				System.out.println(name + "- Aquired a token from Semaphore 10");
				System.out.println(name + "- State 3");
				this.s9.release();
				System.out.println(name + "- Released Semaphore 9");
				this.s10.release();
				System.out.println(name + "- Released Semaphore 10");
				Thread.sleep(this.delay*500);
				System.out.println(name + "- State 4");
				barrier.await();
				System.out.println("T8 was reached by Fir " + name);
				Thread.sleep(8 * 500);
			}catch(InterruptedException e){
				e.printStackTrace();
			}catch(BrokenBarrierException e) {
				throw new RuntimeException(e);
			}
			
		}
	}
}
