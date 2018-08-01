package designpatterns.singleton.lazy;

public class LazyDCL {

    // volatile防止指令重排
    private volatile static LazyDCL singleton;
    private LazyDCL (){}
    public static LazyDCL getSingleton() {
        if (singleton == null) {
            synchronized (LazyDCL.class) {
                if (singleton == null) {
                    singleton = new LazyDCL();
                }
            }
        }
        return singleton;
    }
}
