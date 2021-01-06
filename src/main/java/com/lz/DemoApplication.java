package com.lz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description //TODO 自定义数据源一定要排除SpringBoot自动配置数据源，不然会出现循环引用的问题
 *                      The dependencies of some of the beans in the application context form a cycle
 * @Param
 * @return
 * @Author LZ
 * @Date 2021/1/6 10:19
 **/
@MapperScan("com.lz.mapper")
@EnableTransactionManagement //开启声明式事务
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
