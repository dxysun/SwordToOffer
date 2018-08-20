package myTest.concurents;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i;

   /* public static void main(String[] args) throws
            InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Num:" + i);
        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }*/

   /* public static void main(String[] args) throws
            InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                     //抛出该异常，会将复位标识设置为 false
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//设置复位标识为 true
        System.out.println(thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println(thread.isInterrupted());//false
    }*/
   /* private volatile static boolean stop=false;
    public static void main(String[] args) throws
            InterruptedException {
        Thread thread=new Thread(()->{
            int i=0;
            while(!stop){
                i++;
            }
        });
        thread.start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop=true;
    }*/

    public static void main(String[] args) throws
            InterruptedException{
        Thread thread=new Thread(()->{
            while(true){
                boolean ii=Thread.currentThread().isInterrupted();
                if(ii){
                    System.out.println("before:"+ii);
                    Thread.interrupted();//对线程进行复位，中断标识为 false
                    System.out.println("after:"+Thread.currentThread()
                            .isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();//设置中断标识,中断标识为 true
    }

}
