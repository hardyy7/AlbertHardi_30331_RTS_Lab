package app3;

public class ExecutionThread extends Thread{
    Integer monitor;
    int sleeptime, activity_min, activity_max;
    boolean live = true;
    public ExecutionThread(Integer monitor, int sleeptime, int activity_min, int activity_max){
        this.monitor = monitor;
        this.sleeptime = sleeptime;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }
    public void run() {
        while (live) {
            System.out.println(this.getName() + " - STATE 0");
            synchronized (monitor) {

                System.out.println(this.getName() + " - STATE 1");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 1; i < k * 100000; i++) {
                    i++;
                    i--;
                }
            }
            System.out.println(this.getName() + " - STATE 2");
            try {
                Thread.sleep(sleeptime * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.getName() + " - STATE 3");

        }
    }
}

