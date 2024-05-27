package App2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir1 extends Thread {
    Lock l9,l10;
    CountDownLatch latch;
    int name, sleep, activity_min,activity_max;

    Fir1(int n, int sleep, int a_min, int a_max, Lock la,Lock lb,CountDownLatch latch) {
        this.name = n;
        this.sleep = sleep;
        this.activity_min = a_min;
        this.activity_max = a_max;
        this.latch = latch;
        this.l9 = la;
        this.l10 = lb;
    }
    public void run() {
        while (true) {

            System.out.println(name + " State 1");
            this.l9.lock();
            this.l10.lock();

            System.out.println(name + " acquired the lock" + l9 + " and " + l10);

            System.out.println(name + " State 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            this.l9.unlock();
            this.l10.unlock();
            System.out.println(name + " released the lock" + l9 + " and " + l10);
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(name + " State 3");

            latch.countDown();
            System.out.println("T8 has been reached by Fir "+ name);
            try {
                Thread.sleep(8 * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

