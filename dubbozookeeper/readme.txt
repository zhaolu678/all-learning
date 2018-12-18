dubbo服务：使用单独tomcat部署，默认密码root/root
http://localhost:8080/dubbo-admin/

zookeeper服务：

工程访问路径：
http://localhost:8081/dzdemo/


需要提前准备：zookeeper服务、dubbo_admin(非必须)
zookeeper修改8080端口
修改conf/zoo.cfg文件，添加admin.serverPort=没有被占用的端口号
dubbo_admin 管理端
http://localhost:8080/dubbo-admin/
dubbo-admin默认密码root/root

dubbo+zookeeper整合集成
pom文件引入依赖
<!-- dubbo zookeeper配置 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>4.2.5.RELEASE</version>
</dependency>
<!-- 去掉spring的依赖，不然会有冲突 -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>dubbo</artifactId>
    <version>2.5.3</version>
    <exclusions>
        <exclusion>
            <groupId>org.springframework</groupId>
            <artifactId>spring</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.apache.zookeeper</groupId>
    <artifactId>zookeeper</artifactId>
    <version>3.3.3</version>
</dependency>
<dependency>
    <groupId>com.github.sgroschupf</groupId>
    <artifactId>zkclient</artifactId>
    <version>0.1</version>
</dependency>
dubbo约束
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
             http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd"
       default-lazy-init="false">

生产者provider.xml
<!-- 注册到dubbo的名称 -->
<dubbo:application name="dubbo_provider"></dubbo:application>
<!-- 当前bean -->
<bean id="myServiceImpl" class="com.luchao.serviceimpl.MyServiceImpl"></bean>
<!-- 注册到zookeeper -->
<dubbo:registry address="zookeeper://192.168.52.1:2181" check="false" subscribe="false" protocol="zookeeper"></dubbo:registry>
<!-- 服务提供者 -->
<dubbo:service interface="com.luchao.service.MyService" ref="myServiceImpl" timeout="60000"/>
<!-- 使用指定的协议暴露服务，在多协议时使用，值为<dubbo:protocol>的id属性，多个协议ID用逗号分隔，可以有dubbo/hessian/rmi/thrift/redis等，后面会详细介绍每种协议  -->
<dubbo:protocol name="dubbo" port="12345"/>

发布服务注册到zookeeper（*或者使用tomcat部署）
public static void main(String[] args) throws IOException {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
    context.start();
    System.out.println("服务提供方开始服务");
    System.in.read();
}

服务消费者consumer.xml
<!-- 注册到dubbo的名称 -->
<dubbo:application name="dubbo_consumer"></dubbo:application>
<!-- 注册到zookeeper -->
<dubbo:registry address="zookeeper://192.168.52.1:2181" protocol="zookeeper"></dubbo:registry>
<!-- 服务调用 -->
<dubbo:reference interface="com.luchao.service.MyService" id="myService"/>

