package myTest;

import com.dxy.agent.services.MyService;
import myTest.rmi.Params;

import java.rmi.Naming;

public class GetService {
    public static void main(String[] args) {
        try {
            /*StudentService studentService=(StudentService) Naming.lookup("rmi://127.0.0.1:5008/StudentService");
            List<Student> list = studentService.getList();
            for (Student s : list) {
                System.out.println("姓名："+s.getName()+",年龄："+s.getAge());
            }*/

            Params params = new Params();
            params.setInterface("com.alibaba.dubbo.performance.demo.provider.IHelloService");
            params.setMethod("hash");
            params.setParameter("123");
            params.setParameterTypesString("Ljava/lang/String;");
            MyService myService=(MyService) Naming.lookup("rmi://127.0.0.1:5008/MyService");
            int res = myService.getHashResult(params);
            System.out.println("res：" +res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
