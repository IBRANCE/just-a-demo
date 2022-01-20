package com.zhz.justademo;

import com.zhz.justademo.biz.springretry.controller.RetryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JustADemoApplicationTests {

    @Autowired
    private RetryController retryController;

    @Test
    void contextLoads() {
        retryController.retry();
    }

}
