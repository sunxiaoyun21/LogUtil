package com.allison.logutil.core;

import com.allison.logutil.util.LogUtil;

/**
 * @author 孙小云
 * @date 2020/5/12 11:08
 **/
public class DealMsg extends Thread {

    @Override
    public void run() {
        while (MsgQueue.isFinash()){
            //多态
            //实际中，我们可以定义很多中msg，用type来区分，并通过不同的方法来处理
            //此处运用了这种思想，但是没有实现具体操作
            LogMsg logMsg = MsgQueue.poll();
            switch (logMsg.getMsgType()){
                case "logmsg" :
                    //如果类型是logmsg，那就通过日志来处理
                    dealLogMsg(logMsg);
                    break;
                default:defaultMethod(logMsg);
            }
        }
        this.interrupt();
    }

    private void defaultMethod(LogMsg logMsg) {
        System.out.println("no msg");
    }

    private void dealLogMsg(LogMsg logMsg) {
        LogUtil.write2file(logMsg.getPath(),logMsg.getFileName(),logMsg.getContent());
    }

    @Override
    public synchronized void start() {
        this.run();
    }
}
