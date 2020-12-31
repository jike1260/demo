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
