package jp.tokyo.leon.study.future._03_completablefuture_callback;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author leon
 * @date 2024/2/21 22:52
 */
public class ThenAcceptDemo {

    public static void main(String[] args) {
        // 需求：异步读取 filter_words.txt 文件中的内容，读取完后，把内容替换成数组，然后打印

        CommonUtils.printThreadLog("main start");

         CompletableFuture.supplyAsync(()
                -> CommonUtils.readFile("filter_words.txt"))
                 .thenApply(content -> content.split(","))
                 .thenAccept(filterWords -> CommonUtils.printThreadLog("filterWords = " + Arrays.toString(filterWords)));
        CommonUtils.printThreadLog("main continue");

        CommonUtils.sleepSecond(4);

        CommonUtils.printThreadLog("main end");
    }


}
