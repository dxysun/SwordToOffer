package designpatterns.factory.func;

import designpatterns.factory.Milk;

public class FactoryTest {

    public static void main(String[] args){

        Factory factory = new TelunsuFactory();
        Milk milk = factory.getMilk();
        System.out.println(milk.getName());
    }
}
