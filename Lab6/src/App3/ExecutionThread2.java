package App3;

import java.util.concurrent.CountDownLatch;

class ExecutionThread2 extends Thread {
    Integer monitorP10;
    int activity_min, activity_max,sleep;
    ExecutionThread thread1;
    CountDownLatch latch;
    public ExecutionThread2(Integer monitorP10,int sleep, int activity_min, int activity_max, ExecutionThread thread1, CountDownLatch latch) {
        this.monitorP10 = monitorP10;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.thread1 = thread1;
        this.latch = latch;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 7");
        synchronized (monitorP10) {
            try {

                monitorP10.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(sleep*500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 8 - received token from T10");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 9");

        }
        latch.countDown();
    }
}
