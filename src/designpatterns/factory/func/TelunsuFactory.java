package designpatterns.factory.func;

import designpatterns.factory.Milk;
import designpatterns.factory.Telunsu;

public class TelunsuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Telunsu();
    }
}
