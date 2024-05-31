package app4;

import java.util.concurrent.atomic.AtomicInteger;

public class LeftThread extends Thread {
    Integer monitorTop, monitorBot;
    int sleeptime, activity_min, activity_max;
    public LeftThread(Integer monitorTop, Integer monitorBot, int sleeptime, int activity_min, int activity_max){
        this.monitorTop = monitorTop;
        this.monitorBot = monitorBot;
        this.sleeptime = sleeptime;
        this.activity_min = activity_min;
        this.activity_max = activity_max;

    }

    public void run() {

        //1
        System.out.println(this.getName() + " - STATE 1");
        try {
            Thread.sleep(sleeptime * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 1; i < k * 100000; i++) {
            i++;
            i--;
        }
        //2
        synchronized (monitorBot){
            monitorBot.notify();
        }

        synchronized (monitorTop){
            monitorTop.notify();
        }

        System.out.println(this.getName() + " - STATE 3");


    }

}
