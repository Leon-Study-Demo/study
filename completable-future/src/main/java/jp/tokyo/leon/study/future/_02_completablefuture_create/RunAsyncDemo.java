package jp.tokyo.leon.study.future._02_completablefuture_create;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.concurrent.CompletableFuture;

/**
 * @author leon
 * @date 2024/2/20 00:18
 */
public class RunAsyncDemo {
    public static void main(String[] args) {
        // 回顾线程创建和启动
        new Thread(new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepSecond(3);
                CommonUtils.printThreadLog("读取文件结束");

            }
        }).start();

        // 开启一个异步任务读取文件
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                CommonUtils.printThreadLog("读取文件开始");
                CommonUtils.sleepSecond(3);
                CommonUtils.printThreadLog("读取文件结束");
            }
        });


        /*
         *  completable中的异步任务底层通过开启线程的方式完成的
         */
    }
}
