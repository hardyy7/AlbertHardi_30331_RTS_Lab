package App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir extends Thread{
	Lock l;
    CountDownLatch latch;
    int name, sleep, activity_min,activity_max;
    
	public Fir(int n, int sleep, int a_min, int a_max, Lock la, CountDownLatch latch) {
		this.name = n;
    	this.sleep = sleep;
    	this.activity_min = a_min;
    	this.l = la;
    	this.latch = latch;	}

	public void run() {
    	while(true) {
    		System.out.println(name + "- State 1");
    		this.l.lock();
    		System.out.println(name + "- acquired the lock " + l);
    		
    		System.out.println(name + "- State 2");
    		int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            
            this.l.unlock();
    		System.out.println(name + "- released the lock " + l);
    		
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            
    		System.out.println(name + "- acquired the lock " + l);

            latch.countDown();
            System.out.println("T8 has been reached by "+ name);

            try {
                Thread.sleep(8 * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    	}
    }
}
