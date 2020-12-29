package com.lz.config;

import com.lz.interceptor.ResultInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description TODO WEB配置
 *                  拦截器配置
 *                  跨域配置
 * @Param
 * @Return
 * @Author lz
 * @Date 16:17 2020/12/1
 **/
@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    /**
     * @Description TODO 拦截器配置 本地调试时可先注释
     * @Param [registry]
     * @Return void
     * @Author lz
     * @Date 9:41 2020/11/30
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ResultInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/v3/**","/swagger-resources/**","/swagger-ui/**","/druid/**");
    }

    /**
     * @Description TODO  跨域配置 1允许任何域名使用 2允许任何头 3允许任何方法（post、get等）
     * @Param []
     * @Return org.springframework.web.cors.CorsConfiguration
     * @Author lz
     * @Date 9:40 2020/11/30
     **/
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}
