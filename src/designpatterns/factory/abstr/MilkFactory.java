package designpatterns.factory.abstr;

import designpatterns.factory.Milk;
import designpatterns.factory.Telunsu;
import designpatterns.factory.Yili;

public class MilkFactory extends AbstractFactory{

    @Override
    public Milk getYili() {
        return new Yili();
    }

    @Override
    public Milk getTelunsu() {
        return new Telunsu();
    }
}
