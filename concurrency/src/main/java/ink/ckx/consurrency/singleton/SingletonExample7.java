package ink.ckx.consurrency.singleton;

import ink.ckx.consurrency.annoations.Recommend;
import ink.ckx.consurrency.annoations.ThreadSafe;

/**
 * @author chenkaixin
 * @description 枚举模式：最安全
 * @since 2021/10/31
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    // 私有构造函数
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private final SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}

