package jp.tokyo.leon.study.future._03_completablefuture_callback;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leon
 * @date 2024/2/21 23:19
 */
public class ThenApplyAsyncDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CommonUtils.printThreadLog("main start");
        ExecutorService executor = Executors.newFixedThreadPool(5);

        CompletableFuture<String[]> completableFuture = CompletableFuture.supplyAsync(() -> {
            CommonUtils.printThreadLog("读取filter_words.txt文件");
            return CommonUtils.readFile("filter_words.txt");

        }).thenApplyAsync(filterWords -> {
            CommonUtils.printThreadLog("把文件内容转化成敏感词数组");
            return filterWords.split(",");
        }, executor);


        CommonUtils.printThreadLog("main continue");
        String[] strings = completableFuture.get();
        CommonUtils.printThreadLog("filerWords = " + Arrays.toString(strings));
        executor.shutdown();
        CommonUtils.printThreadLog("main end");
    }
}
