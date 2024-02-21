package jp.tokyo.leon.study.future._03_completablefuture_callback;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author leon
 * @date 2024/2/21 22:40
 */
public class ThenApplyDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 需求：异步读取 filter_words.txt 文件中的内容，读取完后，把内容替换成数组

        CommonUtils.printThreadLog("main start");

        CompletableFuture<String> readFileFuture = CompletableFuture.supplyAsync(() -> CommonUtils.readFile("filter_words.txt"));

        CompletableFuture<String[]> completableFuture = readFileFuture.thenApply((content) -> content.split(","));

        CommonUtils.printThreadLog("main continue");

        String[] filterWords = completableFuture.get();
        CommonUtils.printThreadLog("filterWords = " + Arrays.toString(filterWords));

        CommonUtils.printThreadLog("main end");

    }
}
