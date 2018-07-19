package myTest;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    public Integer call() {
        int sum = 0;
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(10);
                sum += i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public static void main(String[] args) {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        FutureTask<Integer> ft1 = new FutureTask<>(mc);
        Thread thread = new Thread(ft);
        Thread thread1 = new Thread(ft1);
        thread.start();
        thread1.start();
        System.out.println("thread start");
        try {
            System.out.println("FutureTask before get");
            System.out.println(ft.get());          //这里会阻塞
            System.out.println(ft1.get());
            System.out.println("FutureTask after get");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
