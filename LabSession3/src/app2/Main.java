package app2;

public class Main {
    public static void main(String[] args){
        Integer mon1 = new Integer(1);
        Integer mon2 = new Integer(1);
        Integer lock = new Integer(1);

        ExecutionThread et1 = new ExecutionThread(mon1, mon2, lock, 4, new int[]{2, 4}, new int[]{4, 6});
        ExecutionThread et2 = new ExecutionThread(mon2, mon1, lock, 5, new int[]{3, 5}, new int[]{5, 7});

        et1.start();
        et2.start();


    }
}
