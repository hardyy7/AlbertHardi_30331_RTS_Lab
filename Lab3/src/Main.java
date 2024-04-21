import example2.Consumer;
import example2.Producer;

public class Main {
    public static void main(String[] args) {
        example2.Buffer b = new example2.Buffer();
        Producer pro = new Producer(b);
        Consumer c = new Consumer(b);
        Consumer c2 = new Consumer(b);
        pro.start();
        c.start(); c2.start();
    }
}