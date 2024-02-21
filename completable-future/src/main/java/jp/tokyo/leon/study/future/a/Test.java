package jp.tokyo.leon.study.future.a;

import jp.tokyo.leon.study.future.util.CommonUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author leon
 * @date 2024/2/19 23:28
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFuture = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return "sss";
        });

        new Thread(stringFuture).start();
        String s = stringFuture.get();
        System.out.println(s);
    }
}
