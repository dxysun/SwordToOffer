package designpatterns.prototype.gupao.simple;

import java.util.ArrayList;

/**
 * Created by Tom on 2018/3/7.
 */
public class CloneTest {

    public static void main(String[] args) {

        CloneTarget p = new CloneTarget();
        p.name = "Tom";
        p.list = new ArrayList<String>();
        p.list.add("1");
        p.target = new CloneTarget();
        System.out.println(p.target);

        System.out.println(p.list);
        try {
            CloneTarget obj =  (CloneTarget) p.clone();
            System.out.println(obj.target);
            System.out.println(obj.list);
            p.list.set(0,"2");
            System.out.println(obj.list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
