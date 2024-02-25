package jp.tokyo.leon.study.future._04.completablefuture_arrange;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author leon
 * @date 2024/2/26 00:23
 */
// 编排两个依赖关系的异步任务
public class ThenComposeDemo2 {

    public static CompletableFuture<String> readFileFuture(String fileName) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return CommonUtils.readFile(fileName);
        });
    }

    public static CompletableFuture<String[]> splitFuture(String context) {
        return CompletableFuture.supplyAsync(() -> context.split(","));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String[]> completableFuture = readFileFuture("filter_words.txt").thenCompose(ThenComposeDemo2::splitFuture);
        System.out.println(Arrays.toString(completableFuture.get()));
    }
}
