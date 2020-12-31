FROM java:8
VOLUME /tmp
ADD demo-0.0.1.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#FROM pig4cloud/java:8-jre
#
#MAINTAINER lzj_0518@163.com
#
#ENV TZ=Asia/Shanghai
#ENV JAVA_OPTS="-Xms512m -Xmx1024m -Djava.security.egd=file:/dev/./urandom"
#
#RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
#
#RUN mkdir -p /demo
#
#WORKDIR /demo
#
#EXPOSE 8080
#
#ADD ./target/demo-0.0.1.jar ./
#
#CMD sleep 60;java $JAVA_OPTS -jar demo-0.0.1.jar