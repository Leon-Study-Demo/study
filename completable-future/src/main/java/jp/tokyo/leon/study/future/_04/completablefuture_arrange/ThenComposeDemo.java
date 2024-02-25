package jp.tokyo.leon.study.future._04.completablefuture_arrange;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author leon
 * @date 2024/2/26 00:18
 */
public class ThenComposeDemo {

    public static CompletableFuture<String> readFileFuture(String fileName) {
        return CompletableFuture.supplyAsync(() -> {
            return CommonUtils.readFile(fileName);
        });
    }

    public static CompletableFuture<String[]> splitFuture(String context) {
        return CompletableFuture.supplyAsync(() -> {
            return context.split(",");
        });
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<CompletableFuture<String[]>> completableFutureCompletableFuture = readFileFuture("filter_words.txt").thenApply(content -> splitFuture(content));

        CompletableFuture<String[]> completableFuture = completableFutureCompletableFuture.get();
        String[] strings = completableFuture.get();

        System.out.println(Arrays
                .toString(strings));
    }
}
