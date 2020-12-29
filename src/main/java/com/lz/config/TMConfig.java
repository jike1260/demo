package com.lz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

/**
 * @ClassName TransactionalConfig
 * @Description //TODO 事务管理器配置
 * @Author lz
 * @Date 14:32 2020/12/29
 */
public class TMConfig implements TransactionManagementConfigurer {

    @Autowired
    private PlatformTransactionManager txManager;

    /**
     * @Description TODO 创建事务管理器
     * @Param [dataSource]
     * @Return org.springframework.transaction.PlatformTransactionManager
     * @Author lz
     * @Date 14:38 2020/12/29
     **/
    @Bean(name = "txManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        return txManager;
    }
}
