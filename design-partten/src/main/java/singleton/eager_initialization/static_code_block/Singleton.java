package singleton.eager_initialization.static_code_block;

/**
 * @author lone
 */ // 饿汉式-静态代码块
public class Singleton {

    private Singleton(){}

    private static Singleton instance;

    {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

    public String method() {
        return "hello";
    }
}
