package designpatterns.prototype.gupao.simple;

import java.util.ArrayList;

/**
 * Created by Tom on 2018/3/7.
 */
public class Prototype implements Cloneable {

    public String name;

    CloneTarget target = null;

    public ArrayList<String> list;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
