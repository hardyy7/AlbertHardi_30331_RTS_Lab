package example2;

public class Producer implements Runnable {
    private Buffer bf;
    private Thread thread;
    public Producer (Buffer bf){this.bf = bf;}
    public void start(){
        if(thread == null){
            thread = new Thread();
            thread.start();
        }
    }
    @Override
    public void run() {
        bf.put(Math.random());
        System.out.println("Producer " + thread.getName() + "gave a task.");
        try{
            Thread.sleep(1000);
        }catch (Exception e){e.printStackTrace();}
    }
}
