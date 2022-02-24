package com.zhz.justademo.biz.thread;

import com.google.common.collect.Lists;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author nice
 * @create 2022/1/25 2:36 下午
 * @desc
 */
public class CompletableFutureTest {

    public static void main(String[] args) {


    }

    public void demo1() {
        CompletableFuture.runAsync(() -> {
            // 线程中执行业务逻辑


        });
    }

    public void demo2() throws ExecutionException, InterruptedException, TimeoutException {
        List<String> list = Lists.newArrayList();

        // allOf()方法，所有的线程全部正常执行才能
        CompletableFuture.allOf(list.stream()
                .map((artifact) -> CompletableFuture.runAsync(() -> { // 执行单个线程业务逻辑
                    // 执行业务逻辑
                }))
                .toArray(CompletableFuture[]::new)).get(60, TimeUnit.MINUTES);


    }

}
