package com.lz.frame.ds;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description //TODO 自定义动态数据源注解
 *                      默认：ds1
 * @Author LZ
 * @Date 2021/1/6 9:07
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {

    DSEnum value() default DSEnum.ds1;
}
