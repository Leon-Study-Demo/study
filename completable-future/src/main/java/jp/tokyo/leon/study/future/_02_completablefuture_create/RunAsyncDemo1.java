package jp.tokyo.leon.study.future._02_completablefuture_create;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @author leon
 * @date 2024/2/20 00:18
 */
public class RunAsyncDemo1 {
    public static void main(String[] args) {

        // runAsync 创建异步任务
        CommonUtils.printThreadLog("mai start");
        CompletableFuture.runAsync(() -> {
            CommonUtils.printThreadLog("读取文件开始");
            CommonUtils.sleepSecond(3);
            CommonUtils.printThreadLog("读取文件结束");
        });

        CommonUtils.printThreadLog("here is not blocked, main continue");
        CommonUtils.sleepSecond(4);
        CommonUtils.printThreadLog("main end");
    }
}
