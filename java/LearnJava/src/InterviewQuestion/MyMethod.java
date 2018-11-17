package InterviewQuestion;


/*
* 使用synchronized方式进行线程交互，用到的是同步对象的wait,notify和notifyAll方法
* Lock也提供了类似的解决办法，首先通过lock对象得到一个Condition对象，然后分别调用这个Condition对象的：await, signal,signalAll 方法
*
*
* */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyMethod {

    public static void main(String[] args){
        tool pen = new tool();
        run1 runnable1 = new run1(pen);
        run2 runnable2 = new run2(pen);
        Thread thread1 = new Thread(runnable1,"Thread-1");
        Thread thread2 = new Thread(runnable2,"Thread-2");
        thread1.start();
        thread2.start();





    }
}

class run1 implements Runnable{
    private final tool pen_num;
    public run1(tool pen_num){
        this.pen_num = pen_num;
    }
    @Override
    public void run(){
        String[] numarray = tool.generate_num_array(52);
        synchronized (this.pen_num){

            for(int i = 0; i<numarray.length;i+=2){
                try{
                    tool.print(numarray[i],numarray[i+1]);
                    // System.out.println(numarray[i]+" "+numarray[i+1]+" "+i);
                    this.pen_num.notify();
                    // if(i+2<numarray.length)
                    {this.pen_num.wait();}
                }catch (InterruptedException e){
                    System.out.println(e.getStackTrace());
                }
            }
            this.pen_num.notifyAll();
            // if this is not executed, the other thread is going to stuck in the wait()
        }
    }
}

class run2 implements Runnable{
    final tool pen_char;

    public run2(tool pen_char){
        this.pen_char = pen_char;
    }


    @Override
    public void run(){
        String[] chararray = tool.generate_char_array('Z');

        synchronized (this.pen_char){

            for(int i = 0; i<chararray.length;i++){
                try{
                    tool.print(chararray[i]);
                    // System.out.println(chararray[i]+" "+i);
                    this.pen_char.notify();
                    // if (i+1<chararray.length)
                    {this.pen_char.wait();}
                }catch (InterruptedException e){
                    System.out.println(e.getStackTrace());
                }
            }
            this.pen_char.notifyAll();
        }
    }
}

class tool{

    // public int handle = 1;
    public static String[] generate_num_array(int max){
        int i = 0;
        String[] numarray = new String[max];
        while(i<max){
            numarray[i] = Integer.toString(i+1); // index-value: 0-1 ... 25-26
            // System.out.println(numarray[i]);
            i++;
        }
        return numarray;
    }

    public static String[] generate_char_array(char max){
        // Z-A = 90-65 = 25
        int interval = (int)max - (int)'A'+1; // 26 for A-Z, and above
        int min = (int) 'A';
        String[] chararray = new String[interval];
        for(int i=0;i<interval;i++){
            chararray[i] = String.valueOf((char)(min+i));
        }

        return chararray;
    }

    public static void print(String... in){

        if(in==null){
            return;
        }
        else{
            for(String each:in){
                System.out.print(each);
            }
        }
    }
}