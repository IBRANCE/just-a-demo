package com.zhz.justademo.biz.guavaretry;

import com.zhz.justademo.biz.springretry.exception.SelfException;

/**
 * @author nice
 * @create 2022/1/20 3:05 下午
 * @desc
 */
public class MainTest {
    
    
    public void retry(int num) {
        if (num == 1) {
            throw new RuntimeException("num==1 错误信息");
        } else if (num == 2) {
            // TODO 假设这里需要重试，则直接调用util，就会重试当前方法
            throw new SelfException();
        }
    }

}
