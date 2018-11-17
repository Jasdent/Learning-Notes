package multithreading;

public class understandingjoin {


    public static void main(String[] args)
    {Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 20 ; i++){
                System.out.println("I love Brandy. " + Thread.currentThread().getName());
            }
        }
    },"Thread-0");
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i = 0; i < 20 ; i++){
                System.out.println("I love ZISHEN. " + Thread.currentThread().getName());
            }
        }
    },"Thread-0");

    t1.start();
    t2.start();

    try {
        t1.join();
        t2.join();
    }catch (InterruptedException e){e.printStackTrace();}

    }


}
