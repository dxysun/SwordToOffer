package myTest;



import java.lang.reflect.Method;

public class MyReflect {

    public String test1(String str){
        System.out.println("hello " + str);
        return str;
    }

    public void test2(){
        System.out.println("hello test2");
    }

    public static void main(String[] args) {

        Class clazz = MyReflect.class;

        Method[] ms = MyReflect.class.getMethods();
       // MyReflect my = new MyReflect();

        try {

            MyReflect my = (MyReflect)clazz.newInstance();
            for(Method m : ms){
           //     System.out.println(m.toString());
                if(m.toString().contains("myTest.MyReflect.test1")){
                    String  my1 = (String)m.invoke(my,new String[]{"dxy"});
                    System.out.println(my1);
                }

                if(m.toString().contains("myTest.MyReflect.test2")){
                    m.invoke(my);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
}
