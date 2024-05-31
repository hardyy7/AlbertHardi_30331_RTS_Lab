package Application1a;


public class Main {
	public static void main(String[] args) {
		Integer P9monitor = new Integer(1);
		Integer P10monitor = new Integer(1);
		new Thread0(P9monitor, 4, 2, 4).start();
		new Thread1(P9monitor,P10monitor, 3, 3, 6).start();
		new Thread2(P10monitor, 5, 2, 5).start();
	}

}
