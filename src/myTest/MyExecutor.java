package myTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutor {


    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
        try{
            for (int i = 0; i < 5; i++) {
//            executorService.execute(new MyRunnable());
//                Future<Integer> f = executorService.submit(new MyCallable());
               Future<Integer> f = executorService.submit(new MyRunnable(),i);
               System.out.println(f.get());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        executorService.shutdown();
    }
}
class MyRunnable implements Runnable{

    @Override
    public void run() {
        int sum = 0;
        try {
            for(int i = 0;i <= 100;i ++){
                sum += i;
                Thread.sleep(10);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread() + ":" + sum);
    }
}
