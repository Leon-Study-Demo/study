package jp.tokyo.leon.study.future._03_completablefuture_callback;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/**
 * @author leon
 * @date 2024/2/21 23:01
 */
public class ThenRunDemo {

    public static void main(String[] args) {
        CommonUtils.printThreadLog("main start");

        CompletableFuture.supplyAsync(() -> CommonUtils.readFile("filter_words.txt"))
                .thenRun(() -> CommonUtils.printThreadLog("读取文件结束"));


        CommonUtils.printThreadLog("main continue");
        CommonUtils.sleepSecond(4);
        CommonUtils.printThreadLog("main end");
    }
}
