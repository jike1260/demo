package com.lz.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName DruidConfig
 * @Description //TODO druid 监控配置
 * @Author lz
 * @Date 9:55 2020/12/2
 */
@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 白名单
        //servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // 黑名单
        //servletRegistrationBean.addInitParameter("deny", "192.168.28.200");
        // 用户名
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        // 密码
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        // 是否可以重置数据源
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 监控所有请求
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", ".js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
}
