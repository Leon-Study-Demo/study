package singleton.lazy_initialization.unsafe;

/**
 * @author leon
 * @date 2024/1/10 00:07
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public String method() {
        return "hello";
    }

}
