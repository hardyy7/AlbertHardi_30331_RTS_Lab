package Application4a;

public class Main {

	public static void main(String[] args) {
		Integer p6Monitor = new Integer(0);
		Integer p10Monitor = new Integer(0);
		
		Thread0 t0 = new Thread0(p6Monitor,p10Monitor,7,2,3);
		t0.start();
		new Thread1(p6Monitor,3,5,t0).start();
		new Thread2(p10Monitor,4,6,t0).start();
		
	}
	
}
