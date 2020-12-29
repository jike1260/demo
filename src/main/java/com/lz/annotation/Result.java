package com.lz.annotation;

import java.lang.annotation.*;

/**
 * @ClassName ObjResult
 * @Description //TODO 标记返回结果是否需要封装
 * @Author lz
 * @Date
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
@Documented
public @interface Result {
}
