package Application2;

public class Main {

	public static void main(String[] args) {
		Integer p9Monitor = new Integer(1);
		Integer p10Monitor = new Integer(1);
		
		Thread0 thread0 = new Thread0(p9Monitor, p10Monitor, 4, 2, 4, 4, 6);
		Thread1 thread1 = new Thread1(p9Monitor, p10Monitor, 5, 3, 5, 5, 7);
		
		thread0.start();
		thread1.start();
	}
}
