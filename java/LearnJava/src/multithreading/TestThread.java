

class RunnableDemo1 implements Runnable{
    // the class implements Runnable, it is considered to be valid kind of Runable
    // this class is intended to be executed as a thread
    private Thread t = null;
    private String threadName = null;

    RunnableDemo1(String name){
        this.threadName = name;
        System.out.println("Creating "+this.threadName);
    }

    public void start(){
        System.out.println("Starting thread "+this.threadName);
        if(this.t == null){
            this.t = new Thread(this,this.threadName);
            this.t.start();
        }
    }

    public void run(){
        System.out.println("Running "+this.threadName);
        try{
            // what the thread is doing
            for(int i = 4;i>0;i--){
                System.out.println("Thread "+this.threadName+", run "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ie){
            System.out.println(ie);
        }
        System.out.println("Thread "+this.threadName +" exiting");
    }

}

class ThreadDemo2 extends Thread{
    private Thread t = null;
    private String threadName;

    ThreadDemo2(String name){
        this.threadName=name;
        System.out.println("Creating thread "+this.threadName);
    }


    public void start(){
        System.out.println("Starting "+this.threadName);
        if(this.t == null){
            this.t = new Thread(new Runnable(){
                @Override
                public void run(){
                    System.out.println("I am Jasdent");
                    System.out.println("Exiting");
                }
            },this.threadName);
            this.t.start();
        }
    }

    @Override
    public void run(){
        System.out.println("Runing "+this.threadName);
        System.out.println("Running "+this.threadName);
        try{
            for(int i = 4;i>0;i--){
                System.out.println("Thread "+this.threadName+", run "+i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException ie){
            System.out.println(ie);
        }
        System.out.println("Thread "+this.threadName +" exiting");
    }

}

class sidecallThread implements Runnable{

    @Override
    public void run(){
        System.out.println("Runing sidecall");
        try {
            System.out.println("I love brandy");
            Thread.sleep(1000);
            System.out.println("I love brandy");
            ThreadDemo2.sleep(1000);
            System.out.println("Exiting");
        }
        catch (InterruptedException ie){
            System.out.println("FUCK");
        }
    }

}

public class TestThread {
    public static void main(String[] args){
//        RunnableDemo1 R1 = new RunnableDemo1("Thread-1");
//        R1.start();
//        RunnableDemo1 R2 = new RunnableDemo1("Thread-2");
//        R2.start();

        ThreadDemo2 t1 = new ThreadDemo2("Thread-1");
        sidecallThread s1 = new sidecallThread();
        t1.start();
    }
}
