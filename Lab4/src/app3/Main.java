package app3;


public class Main {
    public static void main(String[] args){
        Integer monitor = new Integer(1);
        ExecutionThread et0 = new ExecutionThread(monitor, 5, 3, 6);
        ExecutionThread et1 = new ExecutionThread(monitor, 3, 4, 7);
        ExecutionThread et2 = new ExecutionThread(monitor, 6, 5, 7);

        et0.start();
        et1.start();
        et2.start();
    }
}
