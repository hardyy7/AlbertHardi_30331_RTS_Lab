package Application2;

public class Main {
	
	private static final int noOfThreads = 6;
	private static final int processorLoad = 1000000;
	
	public static void main(String[] args) {
		Model model = new Model(processorLoad);
		View view = new View(noOfThreads);
		Controller controller = new Controller(model,view);
		controller.executeTasks(noOfThreads);
	}
}
