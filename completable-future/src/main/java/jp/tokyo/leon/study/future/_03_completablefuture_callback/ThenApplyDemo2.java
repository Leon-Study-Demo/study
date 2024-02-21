package jp.tokyo.leon.study.future._03_completablefuture_callback;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author leon
 * @date 2024/2/21 22:48
 */
public class ThenApplyDemo2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 需求：异步读取 filter_words.txt 文件中的内容，读取完后，把内容替换成数组

        CommonUtils.printThreadLog("main start");

        CompletableFuture<String[]> completableFuture = CompletableFuture.supplyAsync(()
                -> CommonUtils.readFile("filter_words.txt")).thenApply(content -> content.split(","));


        CommonUtils.printThreadLog("main continue");

        String[] filterWords = completableFuture.get();
        CommonUtils.printThreadLog("filterWords = " + Arrays.toString(filterWords));

        CommonUtils.printThreadLog("main end");
    }
}
