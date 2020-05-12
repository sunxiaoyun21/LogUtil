package com.allison.logutil.core;

import java.util.ResourceBundle;

/**
 * 加载配置信息，基础工具类
 * @author 孙小云
 * @date 2020/5/12 10:49
 **/
public class ConfigurationUtil {

    private static Object lock = new Object();

    private static ConfigurationUtil config = null;

    private static ResourceBundle rb = null;

    private ConfigurationUtil(String filename) {

        rb = ResourceBundle.getBundle(filename);

    }

    public static ConfigurationUtil getInstance(String filename) {

        synchronized (lock) {

            if (null == config) {

                config = new ConfigurationUtil(filename);

            }

        }

        return (config);

    }

    public String getValue(String key) {

        String ret = "";

        if (rb.containsKey(key)) {

            ret = rb.getString(key);

        }

        return ret;

    }
}
