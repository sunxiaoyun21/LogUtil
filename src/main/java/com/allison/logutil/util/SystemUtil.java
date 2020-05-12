package com.allison.logutil.util;

/**
 * 用于判断当前系统
 * @author 孙小云
 * @date 2020/5/12 10:53
 **/
public class SystemUtil {

    /**

     * 判断系统时win还是linux

     * @return

     */

    public static boolean isLinux(){

        String name = System.getProperty("os.name");

        if(name.toLowerCase().startsWith("win"))

            return false;

        else

            return true;

    }

}
