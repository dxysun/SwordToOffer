package myTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;

public class MyTest {

//    String str=new String("hello");
    String str= "hello";
    char[]ch={'a','b'};

    public void change(String str,char ch[]){

        str="test ok";
        ch[0]='c';

    }
    public static void doSomething(int[] a,int start,int end){
        if(start<end){
            int p=core(a,start,end);
            doSomething(a,start,p-1);
            doSomething(a,p+1,end);
        }
    }
    private static int core(int[] a,int start,int end)
    {
        int x=a[end];
        int i=start;
        for(int j=start;j<=end-1;j++){
            if(a[j] < x){
                swap(a,i,j);
                i++;//交换了几次
            }
        }//把最大的放到最后
        swap(a,i,end);//把最大的放到i的位置
        return i;
    }

    private static void swap(int[] a,int i,int j)
    {
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
    public static void main(String args[]){


        LocalDate date = LocalDate.now();
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
        Integer b = new Integer(123);
        


    }
}