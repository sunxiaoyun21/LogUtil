package com.allison.logutil.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @author 孙小云
 * @date 2020/5/12 10:56
 **/
public class FileUtil {

    // 在已经存在的文件后面追加写的方式

    public static boolean write(String path, String str) {

        File f = new File(path);

        File fileParent = f.getParentFile();

        BufferedWriter bw = null;

        try {

            if(!fileParent.exists()){

                fileParent.mkdirs();

            }


            if(!f.exists()){

                f.createNewFile();

            }

            // new FileWriter(name,true)设置文件为在尾部添加模式,参数为false和没有参数都代表覆写方式

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true), "UTF-8"));

            bw.write(str);

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        } finally {

            try {

                if(bw!=null)bw.close();

            } catch (Exception e) {

                System.out.println("FileUtil.write colse bw wrong:" + e);

            }

        }

        return true;

    }

}
