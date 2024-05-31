package L4A2;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class Main {
	public static void main(String args[]) {
		Lock l1 = new ReentrantLock();
		Lock l2 = new ReentrantLock();
		Thread0 thread0 = new Thread0(4, 2, 4, 4, 6, l1, l2);
		Thread1 thread1 = new Thread1(5, 3, 5, 5, 7, l1, l2);
		
		thread0.start();
		thread1.start();
	}
}
