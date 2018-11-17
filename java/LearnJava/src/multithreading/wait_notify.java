package multithreading;
import java.util.concurrent.Callable;

public class wait_notify {

    public static void main(String args[]){
//        counter counter1 = new counter();
//        Thread thread1 = new Thread(counter1,"Thread-1");
//        Thread thread2 = new Thread(counter1,"Thread-2");
//        thread1.start();
//        thread2.start();



        Mything m1 = new Mything();
        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.waiterMehod();
            }
        },"Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                m1.notifierMethod();
            }
        },"Thread-2").start();



    }
}


class counter_1 implements Runnable{

    private int counter;
    counter_1(){
        this.counter=0;
    }

    @Override
    public synchronized void run(){
        while(true){
            if(this.counter % 10 == 0 && this.counter!=0)
            {
                if(this.counter==100) break;
                try {
                    System.out.println("Multiple of 10. rest.");
                    notify();
                    Thread.sleep(2000);
                    wait();
                }catch (InterruptedException i){}
            }
            this.counter++;
            System.out.println("Counter: "+this.counter+" Executor: "+Thread.currentThread());

        }
    }
}



/* a more formal way of using notify and wait */
class Mything{

    public synchronized void waiterMehod() {
        System.out.println("Hi Brandy");// do sth.. prepare for the table, clean
        try{wait();}catch (InterruptedException i){}
        System.out.println("Let's grab a lunch");// continue to do sth..
    }
    public synchronized void notifierMethod(){
        try {
            Thread.sleep(1000);
            System.out.println("Hi Jasdent");// do sth..
            notify(); // notifierMethod still holds the instance object lock until the end of execution
            //System.out.println("NOOO!!!");
            for(int i=0;i<100;i++){
                Thread.sleep(100);
                System.out.println("TESTING "+Thread.currentThread());
            }
        }catch (InterruptedException i){}
         //Wakes up a single thread that is waiting on this object's monitor.
        // continue;


    }
    public synchronized void relatedMethod(){}


}
