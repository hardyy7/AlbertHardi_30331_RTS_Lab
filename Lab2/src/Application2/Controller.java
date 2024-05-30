package Application2;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
        this.view = view;
        this.model.addObserver(view);
	}
	
	public void executeTasks(int numberOfThreads) {
		for (int i = 0; i < numberOfThreads; i++) {
            final int taskId = i;
            new Thread(() -> model.executeTask(taskId)).start(); // Run task in a separate thread
        }
	}

}
