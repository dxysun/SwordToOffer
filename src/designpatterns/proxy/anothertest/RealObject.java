package designpatterns.proxy.anothertest;

public class RealObject implements TestInterface {
    public void doSomething() {
        System.out.println("doSomething.");
    }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}