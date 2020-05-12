package com.allison.logutil.core;

import com.allison.logutil.annotation.LogWrite;
import com.allison.logutil.config.Constants;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙小云
 * @date 2020/5/12 11:07
 **/
public class DealAnnotation {
    //配置文件中设置的log所在地址
    private static String LOG_PATH = ConfigurationUtil.getInstance(Constants.CONFIG_FILE_NAME).getValue(Constants.CONFIG_LOG_PATH);
    //保存那些存在注解的class的类名
    private List<String> registyClasses = new ArrayList<>();
    public void injectAndMakeMsg() {

        //需要扫描的注解可能存在的位置
        String scanPath = ConfigurationUtil.getInstance(Constants.CONFIG_FILE_NAME).getValue(Constants.CONFIG_SACN_PATH);
        doScanner(scanPath);
        for (String className : registyClasses) {
            try {
                Class clazz = Class.forName(className);
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //获取类的所有注解
                    Annotation[] annotations = field.getAnnotations();
                    //没有注解或没有我们的注解，跳过
                    if (0 == annotations.length || !field.isAnnotationPresent(LogWrite.class)) {
                        continue;
                    }

                    //获取注解
                    LogWrite yzLogWrite = field.getAnnotation(LogWrite.class);
                    //提取注解中的值
                    //声明大于配置
                    String path = null == yzLogWrite.path() || yzLogWrite.path().isEmpty() ? LOG_PATH : yzLogWrite.path();
                    String content = null == yzLogWrite.msgPrefix() || yzLogWrite.msgPrefix().isEmpty() ? Constants.DEFAULT_CONTENT_PREFIX : yzLogWrite.msgPrefix();
                    String fileName = null == yzLogWrite.fileName() || yzLogWrite.fileName().isEmpty() ? Constants.DEFAULT_FILE_NAME : yzLogWrite.fileName();
                    int value = yzLogWrite.value();
                    //新建logMsg，在构造函数中已入列
                    new LogMsg(path, content + ":" + value, fileName);
                    //开始注入
                    //强制访问该成员变量
                    field.setAccessible(true);
                    //注入int值
                    field.setInt(Integer.class, value);
                }
            } catch (ClassNotFoundException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void doScanner(String scanPath) {

        URL url = this.getClass().getClassLoader().getResource(scanPath.replaceAll("\\.", "/"));
        File classPath = new File(url.getFile());
        for (File file : classPath.listFiles()) {
            if (file.isDirectory()) {
                //如果是目录则递归调用，直到找到class
                doScanner(scanPath + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (scanPath.replace("/", ".") + "." + file.getName().replace(".class", ""));
                registyClasses.add(className);
            }
        }
    }
}
