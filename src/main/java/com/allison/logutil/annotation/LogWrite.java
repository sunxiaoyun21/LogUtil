package com.allison.logutil.annotation;

import java.lang.annotation.*;

/**
 * @author 孙小云
 * @date 2020/5/12 11:04
 **/
//作用于字段
@Target({ElementType.FIELD})
//运行时生效
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogWrite {


    //需要注解的值
    int value() default -1;
    //默认是Linux系统，默认记录文件夹如下
    String path() default "";
    //文件名
    String fileName() default "";
    //内容
    String msgPrefix() default "";
}
