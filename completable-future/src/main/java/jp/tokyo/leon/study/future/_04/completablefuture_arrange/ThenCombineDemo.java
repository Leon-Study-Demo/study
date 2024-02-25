package jp.tokyo.leon.study.future._04.completablefuture_arrange;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author leon
 * @date 2024/2/26 00:27
 */
public class ThenCombineDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 读取敏感词汇并解析到数组中
        CompletableFuture<String[]> future1 = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取敏感词汇并解析");
            return CommonUtils.readFile("filter_words.txt").split(",");
        });


        // 读取新闻内容
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> CommonUtils.readFile("news.txt"));


        // 编排两个没有依赖关系的异步任务
        CompletableFuture<String> stringCompletableFuture = future1.thenCombine(future2, (filterWords, news) -> {
            for (String filterWord : filterWords) {
                if (news.contains(filterWord)) {
                    news = news.replace(filterWord, "**");
                }
            }
            return news;
        });

        System.out.println(stringCompletableFuture.get());
    }
}
