package com.allison.logutil.core;

/**
 * @author 孙小云
 * @date 2020/5/12 11:01
 **/
public class LogMsg {
    private String path;

    private String content;

    private String fileName;

    private String msgType;

    public LogMsg(String path, String content, String fileName) {

        this.path = path;

        this.content = content;

        this.fileName = fileName;

        this.msgType = "logmsg";

        //在构造函数中就让这个消息入列

        MsgQueue.push(this);

    }

    public String getPath() {

        return path;

    }

    public void setPath(String path) {

        this.path = path;

    }

    public String getContent() {

        return content;

    }

    public void setContent(String content) {

        this.content = content;

    }

    public String getFileName() {

        return fileName;

    }

    public void setFileName(String fileName) {

        this.fileName = fileName;

    }

    public String getMsgType() {

        return this.msgType;

    }

    public void setMsgType(String msgType) {

        this.msgType = msgType;

    }

    @Override

    public String toString() {

        return "LogMsg{" +

                "path='" + path + '\'' +

                ", content='" + content + '\'' +

                ", fileName='" + fileName + '\'' +

                ", msgType='" + msgType + '\'' +

                '}';

    }
}
