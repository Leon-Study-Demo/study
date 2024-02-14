package singleton.lazy_initialization.sync_safe;

/**
 * @author leon
 * @date 2024/1/10 00:15
 */
public class Singleton {
    private static Singleton instance = null;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String method() {
        return "hello";
    }
}
