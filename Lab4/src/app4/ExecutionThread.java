package app4;

import java.util.concurrent.atomic.AtomicInteger;

public class ExecutionThread extends Thread {
    Integer monitor;
    LeftThread lt;
    int  activity_min, activity_max;
    public ExecutionThread(Integer monitor, int activity_min, int activity_max, LeftThread lt){
        this.monitor = monitor;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.lt = lt;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        synchronized (monitor) {
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                this.interrupt();
                System.out.println(this.getName() + " - Was interrupted");
            }
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 1; i < k * 100000; i++) {
            i++;
            i--;
        }

        System.out.println(this.getName() + " - STATE 3");

        if (this.lt != null){
            try {
                this.lt.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
