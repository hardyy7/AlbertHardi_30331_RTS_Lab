package app1;

public class Main {
    public static void main(String[] args){
        Integer monitor1 = new Integer(1);
        Integer monitor2 = new Integer(1);
        ExecutionThread et1 = new ExecutionThread(monitor1, 4, 2, 4);
        MidThread et2 = new MidThread(monitor1, monitor2, 3, 3, 6);
        ExecutionThread et3 = new ExecutionThread(monitor1, 5, 2, 5);

        et1.start();
        et2.start();
        et3.start();

    }
}
