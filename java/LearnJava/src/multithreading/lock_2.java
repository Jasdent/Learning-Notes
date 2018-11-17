package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



public class lock_2 {

    public static void main(String[] args) {
        ThreadSafeArrayList<String> lockExample = new ThreadSafeArrayList<String>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (lockExample.i < 6) {
                    lockExample.set(String.valueOf(lockExample.i));
                    try {

                        Thread.sleep(500);
                    } catch (InterruptedException i) {}
                }
            }
        }, "syncThread");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (lockExample.i < 6) {
                    lockExample.set(String.valueOf(lockExample.i));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException i) {
                    }
                }
            }
        }, "lockingThread");
        ExecutorService e = Executors.newFixedThreadPool(10);



        t1.start();
        t2.start();
    }
}





class ThreadSafeArrayList<E>
{
    private final Lock lock = new ReentrantLock();

    private final List<E> list = new ArrayList<E>();


    public int i = 0;

    public void set(E o)
    {
        lock.lock();

        try
        {
            i+=1;
            list.add(o);

            System.out.println("Adding element by thread"+Thread.currentThread().getName());
        }
        finally
        {
            lock.unlock();
        }
    }

}
