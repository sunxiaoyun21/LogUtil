package com.allison.logutil;

import com.allison.logutil.annotation.LogWrite;
import com.allison.logutil.core.StartWork;

/**
 * @author 孙小云
 * @date 2020/5/12 11:17
 **/
public class Test {

    //因为测试用的main函数是static，所以此时将age设置为static
    @LogWrite(value = 520,msgPrefix = "测试日志是否成功：")
    static int age;
    public static void main(String[] args) {
        StartWork.doWork();
        System.out.println(age);
    }
}
