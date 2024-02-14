package jp.tokyo.leon.threadlocal;

/**
 * @author leon
 * @date 2024/2/10 20:17
 */
public class NormalSample {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static void main(String[] args) {
        NormalSample normalSample = new NormalSample();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                normalSample.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println(Thread.currentThread().getName() + "-->" + normalSample.content );
            });
            thread.setName("线程" + i);
            thread.start();

        }
    }

}
