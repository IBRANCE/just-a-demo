package com.zhz.justademo.biz.springretry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nice
 * @create 2022/1/20 3:10 下午
 * @desc
 */
@RestController
public class RetryController {

    private static final Logger logger = LoggerFactory.getLogger(RetryController.class);

    private AtomicInteger count = new AtomicInteger(1);

    @Retryable(value = RuntimeException.class, maxAttempts = 5)
    public void retry() {
        logger.info("执行重试方法，执行第" + count.getAndIncrement() + "次");
        throw new RuntimeException("代码发生异常");
    }


    @Recover
    public void recevor(RuntimeException e) {
        logger.info("异常信息为：", e);
    }


}
