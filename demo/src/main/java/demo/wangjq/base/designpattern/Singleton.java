package demo.wangjq.base.designpattern;

/**
 * Created by wangjq on 2018/7/3.
 */
public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
    }


    /**
     * 线程不安全懒汉式
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


    /**
     * 线程安全懒汉式
     */
    public static synchronized Singleton getSingleton1() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }


    /**
     * 双重锁线程安全懒汉式
     */
    public static Singleton getSingleton2() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}

/**
 * 饿汉式
 */
class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}

/**
 *静态内部类的单例模式
 */
class StaticClassSingleton {
    private static class SingletonHolder {
        private static final StaticClassSingleton instance = new StaticClassSingleton();
    }

    private StaticClassSingleton() {
    }

    public static StaticClassSingleton getStaticClassSingleton() {
        return SingletonHolder.instance;
    }
}


/**
 * 枚举型单例模式
 */
enum  EnumSingleton {
    INSTANCE;
    public void whateverMethod() {
    }
}
