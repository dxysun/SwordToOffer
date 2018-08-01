package designpatterns.factory.simple;

import designpatterns.factory.Milk;
import designpatterns.factory.Telunsu;
import designpatterns.factory.Yili;

public class SimpleFactory {

    public Milk getMilk(String name){
        if("特仑苏".equals(name))
            return new Telunsu();
        else if("伊利".equals(name))
            return new Yili();
        return null;
    }
}
