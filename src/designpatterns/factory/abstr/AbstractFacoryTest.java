package designpatterns.factory.abstr;

import designpatterns.factory.Milk;

public class AbstractFacoryTest {

    public static void main(String[] args){

        MilkFactory milkFactory = new MilkFactory();

        Milk milk = milkFactory.getYili();
        System.out.println(milk.getName());


    }
}
