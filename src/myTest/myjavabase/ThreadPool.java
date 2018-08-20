package myTest.myjavabase;

import java.util.concurrent.*;

public class ThreadPool {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("runable");
        }
    }
    public static void main(String[] args) {


      /*  LinkedBlockingQueue<Runnable> queue =
                new LinkedBlockingQueue<Runnable>(5);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, queue);
        for (int i = 0; i < 16 ; i++)
        {
            threadPool.execute(
                    new Thread(new MyRunnable(), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0)
            {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();*/

        LinkedBlockingQueue<Runnable> queue =
                new LinkedBlockingQueue<Runnable>(3);
        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, queue,handler);
        for (int i = 0; i < 9 ; i++)
        {
            threadPool.execute(
                    new Thread(new MyRunnable(), "Thread".concat(i + "")));
            System.out.println("线程池中活跃的线程数： " + threadPool.getPoolSize());
            if (queue.size() > 0)
            {
                System.out.println("----------------队列中阻塞的线程数" + queue.size());
            }
        }
        threadPool.shutdown();
      /*  ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();*/
    }
}
