package myTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTest {

    //    String str=new String("hello");
    Node head = new Node(0);
    Node ahead = head;
    static String str;
    String s;
    char[] ch = {'a', 'b'};

    void change(String str, char ch[]) {

        str = "test ok";
        ch[0] = 'c';

    }

    public static void doSomething(int[] a, int start, int end) {
        if (start < end) {
            int p = core(a, start, end);
            doSomething(a, start, p - 1);
            doSomething(a, p + 1, end);
        }
    }

    private static int core(int[] a, int start, int end) {
        int x = a[end];
        int i = start;
        for (int j = start; j <= end - 1; j++) {
            if (a[j] < x) {
                swap(a, i, j);
                i++;//交换了几次
            }
        }//把最大的放到最后
        swap(a, i, end);//把最大的放到i的位置
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String args[]) {


       /* LocalDate date = LocalDate.now();
        int today = date.getDayOfMonth();
        int year = date.getYear();
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.minusDays(today));
        System.out.println(date.minusYears(1));

        float a = 11;
        double d = 1.2e112;
        String str = "1243";
        str.substring(3);
        Integer b = new Integer(123);*/
      /*  String s = "/dubbomesh/com.some.package.IHelloService/192.168.100.100:2000/3";
        int index = s.lastIndexOf("/");
        String weight = s.substring(index + 1,s.length());
        System.out.println("weight=" + weight);
        String temp = s.substring(0,index);
        index = temp.lastIndexOf("/");
        String endpointStr = s.substring(index + 1,temp.length());
        System.out.println("endpointStr=" + endpointStr);
        String strKey = MessageFormat.format("/{0}/{1}/{2}/{3}/{4}","abc","def","htl","sgas","1");
        System.out.println("strKey=" + strKey);*/
        /*MyTest t =  new MyTest();
        t.testNode();*/
       /* Map<String,String> map = new HashMap<>();

        int sum = 2000000;
        long timeStar = System.currentTimeMillis();// 得到当前的时间
        for (int i = 0;i < sum;i ++)
        {
            map.put("Queue-" + i,"message" + i);
        }
        long timeEnd = System.currentTimeMillis();// 得到当前的时间
        System.out.println("save time :" + (timeEnd - timeStar) + "ms");

        timeStar = System.currentTimeMillis();// 得到当前的时间
        System.out.println(map.get("Queue-109998"));
        timeEnd = System.currentTimeMillis();// 得到当前的时间
        System.out.println("read time :" + (timeEnd - timeStar) + "ms");*/

       /*String str = "199998";
       byte[] b = str.getBytes();
       for (byte a : b)
       {
           System.out.println(a);
       }*/

     /*  int a = 16;
       int b = a >> 12;
       System.out.println(b);
       System.out.println(b<<12);*/

      /*  Integer i = 1024;

        System.out.println(Arrays.toString(String.valueOf(i).getBytes()));
        System.out.println(i.byteValue());*/

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<String> sublist = list.subList(4,1);
        for (String a : sublist)
        {
            System.out.println(a);
        }
    /*    String field = "good";
        String str = field + "";
        if(field == str)
            System.out.println("equal");
        else
            System.out.println("not equal");*/

    }

    public void testNode() {

        int[] pos = {1, 2, 1, 2, 2};
        Node temp = head;
        for (int i = 0; i < 5; i++) {
            temp.next = new Node(pos[i]);
            temp = temp.next;
        }
        temp.next = head;


        int j = 0;
        while (true) {
            System.out.println(ahead.val);
            ahead = ahead.next;

            j++;
            if (j > 20)
                break;
        }


    }

    public class Node {

        int val;
        Node next;

        public Node(int t) {
            val = t;
        }
    }
}