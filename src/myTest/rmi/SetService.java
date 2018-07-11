package myTest.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class SetService {
    public static void main(String[] args) {
        try {
            StudentService studentService=new StudentServiceImpl();
            LocateRegistry.createRegistry(5008);//定义端口号
            Naming.rebind("rmi://127.0.0.1:5008/StudentService", studentService);
            System.out.println("服务已启动");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
