package designpatterns.proxy.anothertest;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        RealObject real = new RealObject();
        TestInterface proxy = (TestInterface) Proxy.newProxyInstance(
                TestInterface.class.getClassLoader(), new Class[] {TestInterface.class},
                new DynamicProxyHandler(real));

        proxy.doSomething();
        proxy.somethingElse("luoxn28");
    }
}
