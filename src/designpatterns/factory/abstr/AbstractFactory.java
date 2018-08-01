package designpatterns.factory.abstr;


import designpatterns.factory.Milk;

/**
 * 用户入口
 */
public abstract class AbstractFactory {

    /**
     * 得到某个具体产品
     * @return
     */
    public abstract Milk getYili();
    public abstract Milk getTelunsu();
}
