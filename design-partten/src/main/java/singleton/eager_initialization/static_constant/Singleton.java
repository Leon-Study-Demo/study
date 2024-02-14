package singleton.eager_initialization.static_constant;

/**
 * @author lone
 */ // 饿汉式-静态常量
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {

        return instance;
    }

    public String method() {
        return "hello";
    }
}
