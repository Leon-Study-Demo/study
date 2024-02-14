package jp.tokyo.leon.threadlocal;

/**
 * @author leon
 * @date 2024/2/10 20:25
 */
public class ThreadLocalSample {

    private final ThreadLocal<String> treadLocal = new ThreadLocal<>();

    public void setContent(String content) {
        treadLocal.set(content);
    }

    public String getContent() {
        return treadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalSample threadLocalSample = new ThreadLocalSample();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                threadLocalSample.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println(Thread.currentThread().getName() + "-->" + threadLocalSample.getContent());

            });
            thread.setName("线程" + i);
            thread.start();
        }
    }

}
