package App3;

import java.util.concurrent.CountDownLatch;

class ExecutionThread1 extends Thread {
    Integer monitorP6;
    int activity_min, activity_max,sleep;
    ExecutionThread thread1;
    CountDownLatch latch;

    public ExecutionThread1(Integer monitorP6,int sleep, int activity_min, int activity_max, ExecutionThread thread1, CountDownLatch latch) {
        this.monitorP6 = monitorP6;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.thread1 = thread1;
        this.latch = latch;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 3");
        try {
            Thread.sleep(sleep*500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (monitorP6) {
            try {

                monitorP6.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(this.getName() + " - STATE 4 - received token from T6");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 5");

        }
        latch.countDown();
        try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
