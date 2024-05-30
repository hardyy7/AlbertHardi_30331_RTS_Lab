package Application2;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{
	
	private int processorLoad;
	
	public Model(int processorLoad) {
		this.processorLoad = processorLoad;
	}
	
	public void executeTask(int id) {
		int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            setChanged();
            notifyObservers(new Update(id, c));
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
}
