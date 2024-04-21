package app4;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Integer mon1 = new Integer(1);
        Integer mon2 = new Integer(1);

        LeftThread lt = new LeftThread(mon2, mon1, 7, 2, 3);
        ExecutionThread et1 = new ExecutionThread(mon1, 3, 5, lt);
        ExecutionThread et2 = new ExecutionThread(mon2, 4, 6, lt);

        lt.start();
        et1.start();
        et2.start();


    }
}
