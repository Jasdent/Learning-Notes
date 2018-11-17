package multithreading;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class lock_and_monitor {

    public static void main(String[] args) {


        printsth p1 = new printsth();
        printsth p2 = new printsth();
        thread1 t1 = new thread1(p1);
        thread2 t2 = new thread2(p2);
        Thread t11 = new Thread(t1, "Thread1");
        Thread t22 = new Thread(t2, "Thread2");
        t11.start();
        t22.start();


    }
}




class printsth {
    ReentrantLock lock = new ReentrantLock();
    // all static synchronized methods in a class use the same class object lock
    // all synchronized instance methods in a class USE THE SAME INSTANCE OBJECT LOCK
    public static synchronized void prinsyn(String args){
        System.out.println(args);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){e.printStackTrace();}

    }
    public void print (String args) throws InterruptedException{
        this.lock.lock();
        System.out.println(args);
        Thread.sleep(5000);
        this.lock.unlock();
    }
    public void print2(String args) throws InterruptedException{
        this.lock.lock();
        System.out.println(args);
        System.out.println(args);
        Thread.sleep(2000);
        this.lock.unlock();

    }
}

class thread1 implements Runnable{
    printsth p1;
    @Override
    public void run(){

            try {
                this.p1.prinsyn("Brandy");
                Thread.sleep(1000);
            }catch (InterruptedException i){}


    }

    thread1(printsth p1){
        this.p1 = p1;
    }
}

class thread2 implements Runnable{
    printsth p1;

    thread2(printsth p1){this.p1=p1;}

    @Override
    public void run(){

            try {
                this.p1.prinsyn("Stacey");

                Thread.sleep(1000);
            }catch (InterruptedException i){}


    }
}




