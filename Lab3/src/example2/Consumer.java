package example2;

public class Consumer extends Thread {
    private  Buffer bf;
    public Consumer(Buffer bf){this.bf = bf;}
    public void run(){
        while (true){
            System.out.println("Consumer " + this.getName() + " received >> " + bf.get());
        }
    }
}
