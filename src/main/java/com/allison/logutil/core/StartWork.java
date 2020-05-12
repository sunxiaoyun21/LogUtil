package com.allison.logutil.core;

/**
 * @author 孙小云
 * @date 2020/5/12 11:10
 **/
public class StartWork {
    //程序入口
    public static void doWork(){

        //处理：扫描注解、注入、发送日志消息到队列
        new DealAnnotation().injectAndMakeMsg();
        //创建线程来处理消息
        new DealMsg().start();
    }
}
