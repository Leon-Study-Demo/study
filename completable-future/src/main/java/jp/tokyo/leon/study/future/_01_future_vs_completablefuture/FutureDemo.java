package jp.tokyo.leon.study.future._01_future_vs_completablefuture;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author leon
 * @date 2024/2/19 23:33
 */

// future的局限性
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 替换新闻稿中的敏感词，并替换成*
        ExecutorService executor = Executors.newFixedThreadPool(5);
        // step 1：读取敏感词汇 => thread1
        Future<String[]> filterWordFuture = executor.submit(() -> {
            String str = CommonUtils.readFile("filter_words.txt");
            return str.split(",");
        });
        // step 2：读取新闻稿 => thread2
        Future<String> newsFuture = executor.submit(() -> {
            return CommonUtils.readFile("news.txt");
        });
        // step 3：替换操作 => thread3
        Future<String> replaceFuture = executor.submit(() -> {
            String[] words = filterWordFuture.get();
            String news = newsFuture.get();

            for (String word : words) {
                if (news.contains(word)) {
                    news = news.replace(word, "**");
                }
            }
            return news;
        });
        // step 4：打印输出替换后的新闻稿 => main
        String filteredNews = replaceFuture.get();
        System.out.println("filteredNews = " + filteredNews);
    }

    /*
     * 通过上面代码，可以发现，Future相比于所有任务都在主线程处理，有很多优势，但是同时也有很多不足，至少表现如下：
     *  1. 在没有阻塞的情况下，无法对Future的结果执行进一步操作。
     *  2. 无法解决任务依赖的问题
     *  3. 不能多个Future合并在一起
     *  4. 没有异常处理
     */

}
