package example3;

public class Main {

    static int div_sum;
    public static void main(String[] args) throws Exception{
        JoinTestThread w1 = new JoinTestThread("Thread 1", null, 60000);
        JoinTestThread w2 = new JoinTestThread("Thread 2", w1, 30000);

        w1.start();
        w2.start();


    }
}
