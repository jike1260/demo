package com.lz.frame.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @ClassName BaseController
 * @Description //TODO 基础Controller
 * @Author lz
 * @Date 16:06 2020/12/29
 */
@Slf4j
public abstract class BaseController {

    /**
     * 自动注入此资源对象
     **/
    @Autowired
    private MessageSource messageSource;

    /**
     * @Description TODO 获取配置文件信息
     * @Param [key, args]
     * @Return java.lang.String
     * @Author lz
     * @Date 16:07 2020/12/29
     **/
    public String getMessage(String key, String... args) {
        log.info("获取资源文件信息...");
        return this.messageSource.getMessage(key, args, Locale.getDefault());
    }

    /**
     * @Description TODO 自定义日期格式转换器
     * @Param [binder]
     * @Return void
     * @Author lz
     * @Date 16:06 2020/12/29
     **/
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 首先建立一个可以将字符串转换为日期的工具程序类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 明确的描述此时需要注册一个日期格式的转化处理程序类
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
        log.info("日期格式转换...");
    }
}