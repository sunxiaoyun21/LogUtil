package com.allison.logutil.core;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author 孙小云
 * @date 2020/5/12 11:02
 **/
public class MsgQueue {
    private static Queue queue = new ConcurrentLinkedDeque<>();

    //消息入列

    public static boolean push(LogMsg logMsg){

        return queue.offer(logMsg);

    }



    //消息出列

    public static LogMsg poll(){

        return (LogMsg) queue.poll();

    }



    //消息队列是否已经处理完毕，处理完毕返回true

    public static boolean isFinash(){

        return !queue.isEmpty();

    }
}
