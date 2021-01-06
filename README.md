# 基于SpringBoot2.3.7 优雅的构建Rest风格后端API接口！

### 1.控制屋返回对象可以在类或方法级通过自定义注解 @Result 进行封装 

### 2.全局异常处理【系统级异常】

### 3.自定义异常直接返回 例:R.fail(StatusCode.USER_ACCOUNT_FREEZE)

### 4.集成了druid数据连接池 【访问 http://{ip}:{端口}/druid/index.html】

### 5.集成了Swagger3

### 6.集成了mybatis-plus3.4.1

### 7.集成了Redis

### 8.引入了validation参数校验

### 9.集成docker实现容器化部署 【配置插件docker-maven-plugin】
1. 打包 mvn package
2. 构建 docker build
3. 查看镜像 docker images
4. 启动镜像 docker run -d -p {port}:{port} appName 

### 10.实现多数据源路由
1. pom.xml中追加依赖spring-boot-starter-aop
2. 修改application.yml 在spring.datasource.druid 节点下追加数据源配置 从节点需配置enabled: true
3. 编写数据源枚举 DSEnum
4. 编写自定义注解 DS
5. 编写数据源类 DynamicDataSource extends AbstractRoutingDataSource
6. 编写数据源切换处理类 DynamicDataSourceContextHolder
7. 编写数据源切面处理类 DataSourceAspect
8. 编写配置类 DruidConfig
9. 启动类 @SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
    > 自定义数据源一定要排除SpringBoot自动配置数据源，不然会出现循环引用的问题  
 The dependencies of some of the beans in the application context form a cycle
10. 在service层方法上使用注解 例:@DS(DSEnum.ds2) 完成数据源路由
    
    