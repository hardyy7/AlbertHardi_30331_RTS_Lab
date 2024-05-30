package Application2;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class View extends JFrame implements Observer{
	
	private ArrayList<JProgressBar> bars = new ArrayList<>();
	
	public View(int nbOfThreads) {
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nbOfThreads);
        setVisible(true);
    }
	
    private void init(int n) {
    	for (int i = 0; i < n; i++) {
            JProgressBar pb = new JProgressBar();
            pb.setMaximum(1000);
            pb.setBounds(50, (i + 1) * 30, 350, 20);
            add(pb);
            bars.add(pb);
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
    	if (arg instanceof Update) {
            Update update = (Update) arg;
            int id = update.getId();
            int progress = update.getProgress();
            SwingUtilities.invokeLater(() -> setProgressValue(id, progress)); // Update progress bars on EDT
        }
    }
    
    public void setProgressValue(int id, int val) {
        bars.get(id).setValue(val);
    }
    
	
}
