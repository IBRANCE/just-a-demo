package com.zhz.justademo.biz.designpattern.strategy;

import com.zhz.justademo.biz.designpattern.strategy.after.BaseContext;
import com.zhz.justademo.biz.designpattern.strategy.after.BaseStrategy;

/**
 * @author nice
 * @date 2022/1/22
 * @desc 策略模式的使用
 */
public class MainTest {
    public static void main(String[] args) {
//        BaseStrategy.getInstance(2).action();
        new BaseContext(1).doing();
    }
}
