package app2;

import java.lang.management.MonitorInfo;

public class ExecutionThread extends Thread {
    Integer monitor1, monitor2, lock;
    int sleeptime;
    int[] activity_min, activity_max;
    boolean monitor1Acquired = false;
    boolean monitor2Acquired = false;

    public ExecutionThread(Integer monitor1, Integer monitor2, Integer lock, int sleeptime, int[] activity_min, int[] activity_max) {
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.lock = lock;
        this.sleeptime = sleeptime;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        //1
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max[0] - activity_min[0]) + activity_min[0]);
        for (int i = 1; i < k * 100000; i++) {
            i++;
            i--;
        }
        //2
        synchronized (lock) {
                synchronized (monitor1) {

                    System.out.println(this.getName() + " - STATE 2");
                    k = (int) Math.round(Math.random() * (activity_max[1] - activity_min[1]) + activity_min[1]);
                    for (int i = 1; i < k * 100000; i++) {
                        i++;
                        i--;
                    }

                    //3
                    synchronized (monitor2) {
                        System.out.println(this.getName() + " - STATE 3");


                        try {
                            Thread.sleep(sleeptime * 500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}
