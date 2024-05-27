package L7A4;

import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String args[]) {
		Semaphore s = new Semaphore(2);
		Fir f1,f2,f3;
		f1 = new Fir(1,3,4,7,1,s);
		f2 = new Fir(2,6,5,7,1,s);
		f3 = new Fir(3,5,3,6,1,s);
		
		f1.start();
		f2.start();
		f3.start();
	}
}
