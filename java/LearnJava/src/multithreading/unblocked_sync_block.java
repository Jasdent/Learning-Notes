package multithreading;

import java.io.ObjectOutputStream;

public class unblocked_sync_block {



        public static void main(String[] args) {
//            SynchronizedDemo synDemo = new SynchronizedDemo();
//            Thread thread1 = new Thread(() -> {
//                //调用同步块方法
//                synDemo.chunkMethod();
//                synDemo.chunkMethod2();
//            });
//            Thread thread2 = new Thread(() -> {
//                //调用同步块方法
//                synDemo.chunkMethod2();
//                synDemo.chunkMethod();
//            });
//            thread1.start();
//            thread2.start();


            Object i = new Object();
            Object i2 = new Object();
            Runnable r1 = new Runnable() {
                @Override
                public void run() {

                    System.out.println("I love Brandy. "+Thread.currentThread().getName());
                    try {Thread.sleep(2000);}catch (InterruptedException i){}
                }
            };


            Thread t1 = new Thread(r1,"T1");
            Thread t2 = new Thread(r1,"T2");
            t1.start();
            t2.start();


        }


    }





class SynchronizedDemo{
    private Object lock = new Object();
    private Object lock2 = new Object();
    public void chunkMethod(){
            System.out.println(Thread.currentThread().getName()+" invokes chunkMethod");
            synchronized (lock) {
                try{Thread.sleep(1000);System.out.println(Thread.currentThread().getName()+" acquire lock in chunkMethod");Thread.sleep(1000);}
                catch (InterruptedException i){}

            }
    }

    public void chunkMethod2(){
        System.out.println(Thread.currentThread().getName()+" invokes chunkMethod2");
        // if it synchonize (this), then the synchronisation is up to the class instance level
        synchronized (lock) {
            // lock 锁的不同的同步块
            try{Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" acquire lock in chunkMethod2");Thread.sleep(1000);}catch (InterruptedException i){}

        }
    }

}


//Thread-0 invokes chunkMethod
//Thread-1 invokes chunkMethod2
//Thread-0 acquire lock in chunkMethod
//Thread-0 invokes chunkMethod2
//Thread-1 acquire lock in chunkMethod2
//Thread-1 invokes chunkMethod
//Thread-0 acquire lock in chunkMethod2
//Thread-1 acquire lock in chunkMethod

//Thread-0 invokes chunkMethod
//Thread-1 invokes chunkMethod2
//Thread-0 acquire lock in chunkMethod
//Thread-0 invokes chunkMethod2
//Thread-1 acquire lock in chunkMethod2
//Thread-1 invokes chunkMethod
//Thread-0 acquire lock in chunkMethod2
//Thread-1 acquire lock in chunkMethod
