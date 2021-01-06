package com.lz.frame.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.lz.frame.ds.DSEnum;
import com.lz.frame.ds.DynamicDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName DruidConfig
 * @Description //TODO druid 监控配置、数据源配置
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

    /**
     * @Description //TODO 多数据源配置
     *                      默认:ds1  使用注解路由数据源 @DS(DSEnum.ds2)
     * @Author LZ
     * @Date 2021/1/6 9:57
     **/
    @Bean(name = "ds1")
    @ConfigurationProperties("spring.datasource.druid.ds1")
    public DataSource ds1() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "ds2")
    @ConfigurationProperties("spring.datasource.druid.ds2")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.ds2", name = "enabled", havingValue = "true")
    public DataSource ds2() {
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "ds3")
    @ConfigurationProperties("spring.datasource.druid.ds3")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.ds3", name = "enabled", havingValue = "true")
    public DataSource ds3() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>(4);
        targetDataSources.put(DSEnum.ds1.name(), ds1());
        targetDataSources.put(DSEnum.ds2.name(), ds2());
        targetDataSources.put(DSEnum.ds3.name(), ds3());
        return new DynamicDataSource(ds1(), targetDataSources);
    }
}
