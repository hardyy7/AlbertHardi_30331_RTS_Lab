package example3;

public class JoinTestThread extends Thread{
    Thread t;
    int sum, num;
    JoinTestThread(String n, Thread t, int num){
        this.setName(n);
        this.t = t;
        this.sum = 0;
        this.num = num;
    }
    public void run(){
        System.out.println("Thread "+ this.getName() + " has entered the run() method");
        try{
            if(t != null) t.join();
            System.out.println("Thread " + this.getName() + " executing operation");
            for(int i = 1; i <= this.num; i++){
                if(this.num % i == 0){
                    this.sum += i;
                }
                Main.div_sum = sum;
            }
            Thread.sleep(3000);
            System.out.println("Thread " + this.getName() + " has terminated operation.");
            System.out.println("The sum of divisors, which " + this.getName() + " has find: " + Main.div_sum);
        }
        catch (Exception e){e.printStackTrace();}
    }

    public int getSum(){
        return this.sum;
    }
}
