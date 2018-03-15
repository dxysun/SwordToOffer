import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

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
    /*    MyTest ex=new MyTest();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);*/
       /* String s= "hello";
        String t= "hello";
        char c[] ={'h','e','l','l','o'};*/
       /* int[] a={2,4,6,8,3,6,9,12};
        doSomething(a,0,a.length-1);
        for(int i=0;i<=a.length-1;i++)
            System.out.print(a[i]+" ");*/
      //  Scanner in = new Scanner(System.in);
/*
        System.out.printf("Hello,%s.Next year ,you'll be %d\n","abc",22);
        System.out.println(10000.0/3.0);
        System.out.printf("%,.2f\n",10000.0/3.0);
        System.out.printf("%8.2f\n",10000.0/3.0);  //八个字符的宽度
        BigInteger b =BigInteger.valueOf(1000);
        BigDecimal d = BigDecimal.valueOf(100.0);*/

        LocalDate date = LocalDate.now();
        int today = date.getDayOfMonth();
        int year = date.getYear();
        System.out.println(date.getDayOfMonth());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.minusDays(today));
        System.out.println(date.minusYears(1));


    }
}