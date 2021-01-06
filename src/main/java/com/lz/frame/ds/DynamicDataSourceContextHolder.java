package com.lz.frame.ds;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName DynamicDataSourceContextHolder
 * @Description TODO 数据源切换处理
 * @Author LZ
 * @Date 2021/1/6 9:27
 * @Version 1.0
 **/
@Slf4j
public class DynamicDataSourceContextHolder {
    /**
     * TODO 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     *      所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     **/
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源的变量
     */
    public static void setDateSource(String ds) {
        log.info("切换到{}数据源", ds);
        CONTEXT_HOLDER.set(ds);
    }

    /**
     * 获得数据源的变量
     */
    public static String getDateSource() {
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清空数据源变量
     */
    public static void clearDateSource() {
        CONTEXT_HOLDER.remove();
    }
}
