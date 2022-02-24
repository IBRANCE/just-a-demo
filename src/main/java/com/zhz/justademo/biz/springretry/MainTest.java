package com.zhz.justademo.biz.springretry;

import com.zhz.justademo.biz.springretry.exception.SelfException;

public class MainTest {
    

    
    public void retry(int num) {
        if (num == 1) {
            throw new RuntimeException("num==1 错误信息");
        } else if (num == 2) {
            throw new SelfException();
        }
    }

}
