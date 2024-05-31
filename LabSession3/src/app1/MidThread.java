package app1;

public class MidThread extends Thread {
    Integer monitor1, monitor2;
    int sleeptime, activity_min, activity_max;
    boolean passed;
    public MidThread(Integer monitor1, Integer monitor2, int sleeptime, int activity_min, int activity_max){
        this.monitor1 = monitor1;
        this.monitor2 = monitor2;
        this.sleeptime = sleeptime;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        passed = false;

    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");


            synchronized (monitor1) {
                System.out.println(this.getName() + " - STATE 2_P9");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 1; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                passed = true;
            }
        }
        /*-
            synchronized (monitor2) {
                System.out.println(this.getName() + " - STATE 2_P10");
                int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
                for (int i = 1; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                passed = true;
            }
        */

}
