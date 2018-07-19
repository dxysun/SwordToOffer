package myTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

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

//    volatile
    public static void main(String args[]) {

        float f1 = 34;
        float f2 = 3.14F;
        Float f3 = 23F;
        double d1 = 8;
        Double d2 = 234d;

        Integer a = -16;

        a = a>>>1;

        StringBuffer sb = new StringBuffer();
        StringBuilder sb1 = new StringBuilder();
        String s = Integer.toBinaryString(a);
        System.out.println(a);
        System.out.println(s);
        System.out.println(s.length());

        BigInteger bigInteger = BigInteger.valueOf(234);



    }
    static int test()
    {
        int x = 1;
        try
        {
            return x;
        }
        finally
        {
            ++x;
        }
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