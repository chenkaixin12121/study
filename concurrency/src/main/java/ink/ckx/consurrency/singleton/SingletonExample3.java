package ink.ckx.consurrency.singleton;

import ink.ckx.consurrency.annoations.NotRecommend;
import ink.ckx.consurrency.annoations.ThreadSafe;

/**
 * @author chenkaixin
 * @description 懒汉模式 单例实例在第一次使用时进行创建
 * @since 2021/10/31
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 单例对象
    private static SingletonExample3 instance = null;

    // 私有构造函数
    private SingletonExample3() {

    }

    // 静态的工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
