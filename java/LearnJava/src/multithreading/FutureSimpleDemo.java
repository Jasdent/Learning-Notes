package multithreading;

import java.util.concurrent.*;



class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        System.out.println("做一些耗时的任务...");
        Thread.sleep(5000);
        return "OK";
    }
}

public class FutureSimpleDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println("dosomething...");


//        System.out.println("Completed!");
    }
}




class CallableAndFuture {
    public static void main22(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                return new Integer(1);
            }
        };
        FutureTask<Integer> future = new FutureTask<Integer>(callable);
        new Thread(future).start(); // FutureTask passed as runnable to the thread
        try {
            Thread.sleep(3000);// 可能做一些事情
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
