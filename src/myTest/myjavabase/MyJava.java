package myTest.myjavabase;


import sun.security.provider.certpath.Vertex;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class MyJava {


  /*
  // 返回结果不同不认为是重载

  public void mytest(int a){
        System.out.println("test");
    }
    public int mytest(int a){
        System.out.println("test");
        return 0;
    }*/

    volatile int a = 0;

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        Hashtable<String,String> hashtable = new Hashtable<>();
        HashMap<String,String> hashMap = new HashMap<>();
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();

        TreeMap<String,String> treeMap = new TreeMap<>();

        ReentrantLock lock = new ReentrantLock();
//        Collections;
        ArrayList<String> arrayList = new ArrayList<>();

        Vector<String> vector = new Vector<>();
        Stack<String> stack = new Stack<>();

        System.out.println(Integer.bitCount(7));

        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);

        List<String> list1 = new CopyOnWriteArrayList<>();

        HashMap<Integer, String> map = new HashMap<>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();
        map.put(7, "");
        map.put(11, "");
        map.put(43, "");
        map.put(59, "");
        map.put(19, "");
        map.put(3, "");
        map.put(35, "");

        System.out.println("遍历结果：");
        for (Integer key : map.keySet()) {
            System.out.print(key + " -> ");
        }
       /* Thread thread = new Thread(() ->{
            int a = 1+ 1;
        });
        thread.join();

        String test = "你好";
        String test1 = new String(test.getBytes("gbk"),"gbk");
        System.out.println(test1);*/


    }
}
