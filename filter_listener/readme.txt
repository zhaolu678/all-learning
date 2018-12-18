Java过滤器filter
1、 在Java Web中，在传入的request、response提前过滤掉一些信息、提前设置一些参数、统一设置字符集、控制是否登录等，然后在传入Servlet等中进行处理。
2、Filter链： 一个Web应用中，可以编写多个Filter，这些Filter组合起来称之为一个Filter链。Web服务器根据Filter在web.xml文件中的注册顺序，决定先调用哪个Filter。
3、 当第一个Filter的doFilter方法被调用时，web服务器会创建一个代表Filter链的FilterChain对象传递给该方法。在doFilter方法中，开发人员如果调用了FilterChain对象的doFilter方法，则web服务器会检FilterChain对象中是否还有filter，如果有，则调用第2个filter，如果没有，则调用目标资源。
实现步骤：
1.实现Filter接口
2.web.xml中配置
<filter>
        <filter-name>demofilter</filter-name>
        <filter-class>com.luchao.demofilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>demofilter</filter-name>
        <url-pattern>*</url-pattern>
    </filter-mapping>

java监听器listener
1、 Servlet的监听器Listener，它是实现了javax.servlet.ServletContextListener接口的服务器端程序，它也是随web应用的启动而启动，只初始化一次，随web应用的停止而销毁。
2、  主要作用是：做一些初始化的内容添加工作、设置一些基本的内容（比如一些参数或者是一些固定的对象等）。
实现步骤：
1.实现ServletContextListener接口
2.web.xml中配置监听
<listener>
        <listener-class>com.luchao.InitDataListener</listener-class>
</listener>


spring拦截器Interceptor
简介
SpringMVC的处理器拦截器，类似于Servlet开发中的过滤器Filter，用于对请求进行拦截和处理。
常见应用场景
1、权限检查：如检测请求是否具有登录权限，如果没有直接返回到登陆页面。
2、性能监控：用请求处理前和请求处理后的时间差计算整个请求响应完成所消耗的时间。
3、日志记录：可以记录请求信息的日志，以便进行信息监控、信息统计等。

第一种实现HandlerInterceptor接口，第二种是实现WebRequestInterceptor接口

<mvc:interceptors>
    <!--对所有的请求记性拦截-->
    <!--<beans:beanclass="com.sunp.common.interceptor.Myinterceptor"/>-->
        <!--对特定的请求进行拦截-->
    <mvc:interceptor>
        <!--进行拦截的路径-->
        <mvc:mapping path="/**"/>
        <!--不进行拦截的路径-->
        <mvc:exclude-mapping path="/lib/**" />
        <beans:bean class="com.sunp.common.interceptor.Myinterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
执行顺序

1、单个实现类的执行顺序

preHandler -> Controller -> postHandler -> model渲染-> afterCompletion

2、多个实现类的执行顺序

———————preHandler1——————-
———————preHandler2——————-
———————preHandler3——————-
———————–Controller———————
———————postHandler3——————
———————postHandler2——————
———————postHandler1——————
———————postHandler1——————
——————afterCompletion3—————-
——————afterCompletion2—————-
——————afterCompletion1—————-





