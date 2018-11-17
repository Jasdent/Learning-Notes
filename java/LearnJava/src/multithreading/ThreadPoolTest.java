package multithreading;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args){

        Executor executor = Executors.newFixedThreadPool(5);


    }
}


class ThreadPool{
    private int poolsize;

    public ThreadPool(int poolsize){
        this.poolsize = poolsize;
    }

    LinkedList<Runnable> run_list = new LinkedList<>();

    public void add(Runnable task){
        synchronized (run_list) {

            this.run_list.add(task); // lock run_list, only add one at a time
            this.run_list.notifyAll(); // when something is added, break out the waiting

        }
    }

    class executeThread extends Thread{

        Runnable job;
        @Override
        public void run(){
            while(true){

                synchronized (run_list){
                    try{
                        while(run_list.isEmpty()){
                            run_list.wait();
                        }
                        run_list.notifyAll();
                        this.job = run_list.removeLast();

                    }catch (InterruptedException e){e.printStackTrace();}
                }

                this.job.run();
            }
        }


    }



}