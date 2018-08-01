package designpatterns.factory.func;

import designpatterns.factory.Milk;
import designpatterns.factory.Yili;

public class YiliFactory implements Factory{

    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
