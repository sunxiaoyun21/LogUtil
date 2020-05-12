package com.allison.logutil.util;

import com.allison.logutil.config.Constants;

import java.util.Date;

/**
 * @author 孙小云
 * @date 2020/5/12 10:58
 **/
public class LogUtil {
    //日志写入操作
    public static void write2file(String path, String fileName, String content) {


        //获取当前日期，我们的日志保存的文件夹名是自定义path+日期
        String date = DateUtil.dateToString(new Date()) + "/";

        try {

            //传了path，那我们直接用这个path

            if (null != path && 0 != path.length()) {

                //写入
                FileUtil.write(path + date + fileName + ".txt",

                        DateUtil.dateToString(new Date()) + ":" + content + "\r\n");

            } else {

                //没有传path或错误使用默认的路径

                if (SystemUtil.isLinux()) {

                    FileUtil.write(Constants.LINUX_LOG_PATH + date + fileName + ".txt",

                            DateUtil.dateToString(new Date()) + ":" + content + "\r\n");

                } else {

                    FileUtil.write(Constants.WIN_LOG_PATH + date + fileName + ".txt",

                            DateUtil.dateToString(new Date()) + ":" + content + "\r\n");
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
