package com.allison.logutil.config;

/**
 * @author 孙小云
 * @date 2020/5/12 10:46
 **/
public interface Constants {


    //等下要引入的配置文件名

    String CONFIG_FILE_NAME = "logconfig";

    //配置文件中配置的日志路径

    String CONFIG_LOG_PATH = "logpath";

    //配置文件中配置的要扫描的，可能存在我们注解的路径

    String CONFIG_SACN_PATH = "scanpath";

    //若未声明某些信息，则使用以下默认值

    //默认的我们的日志信息前缀，对日志信息做简单描述

    String DEFAULT_CONTENT_PREFIX = "注入值：";

    //默认的日志文件名（实际写入时会在日志文件名后加上日期标签）

    String DEFAULT_FILE_NAME = "log";

    //日志信息类型，处理消息时会用到

    String MSG_TYPE_LOG = "log";

    //默认的Linux系统下的日志路径

    String LINUX_LOG_PATH = "/home/data/";

    //默认的Windows系统下的日志路径

    String WIN_LOG_PATH = "D:/winLog/data/";
}
