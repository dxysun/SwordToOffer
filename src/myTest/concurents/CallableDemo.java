package myTest.concurents;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
    public static void main(String[] args) throws ExecutionException,
            InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);
        CallableDemo callableDemo = new CallableDemo();
        Future<String> future = executorService.submit(callableDemo);
        System.out.println("thread start");
        System.out.println(future.get());
        System.out.println("thread end");
        executorService.shutdown();
    }

    @Override
    public String call() throws Exception {
        int a = 1;
        int b = 2;
        Thread.sleep(3000);
        System.out.println(a + b);
        return "执行结果:" + (a + b);
    }
}
