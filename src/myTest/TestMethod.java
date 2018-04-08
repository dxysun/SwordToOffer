package myTest;

import java.util.ArrayList;

public class TestMethod extends People{

  //  int age;

    public void myMethod()
    {
        age = 13;
    }
    public ArrayList getLsit()
    {
        ArrayList a = new ArrayList();
//        a.add(1);
        return a;
    }
    public static void setValue(String str)
    {
        str = "new value";
        System.out.println("setValue method:" + str);
    }

    public static void setReferenceValue(People p)
    {
        p.setName("new name");
        System.out.println("setReferenceValue method:" + p.getName());
    }
    public static void swapReference(People p1,People p2)
    {
        People p = p1;
        p1 = p2;
        p2 = p;
        System.out.println("swapReference method p1:" + p1.getName());
        System.out.println("swapReference method p2:" + p2.getName());
    }
    public static void main(String[] args)
    {


        float f = 5;
        Float f1 = 45f;
        double d = 45;
        Double d1 =  45d;
        System.out.println("f :" + d);


        Integer a = new Integer(123);
        Integer b = 123;
       /*  int a = 148;
       int b = 128;*/
        Integer c = a;
        c ++;
        System.out.println("a:" + a);
        System.out.println("c:" + c);
        if(a == b)
            System.out.println("a == b");
        else
            System.out.println("a != b");

       /* if(b.equals(a))
            System.out.println("a equals b");
        else
            System.out.println("a !equals b");
*/

    }
}
class People{

    private String name;

    protected int age;
    public People()
    {

    }
    public People(String name)
    {
        this.name = name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
