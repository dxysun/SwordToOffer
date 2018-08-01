package designpatterns.singleton.lazy;

public class LazyInnerClass {

    private static class SingletonHolder {
        private static final LazyInnerClass INSTANCE = new LazyInnerClass();
    }
    private LazyInnerClass (){}
    public static final LazyInnerClass getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
