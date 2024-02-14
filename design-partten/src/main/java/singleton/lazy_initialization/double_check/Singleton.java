package singleton.lazy_initialization.double_check;

/**
 * @author leon
 * @date 2024/1/10 00:17
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    /*
      这里就是相当于在同步方法外面包了一层判断，因为单例创建出来以后，大部分的时候都是不为null的
      所以这样做不会一直进入同步代码块造成性能问题
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public String method() {
        return "hello";
    }
}
