package com.luchao;
import javax.servlet.*;
import java.io.IOException;

public class demofilter implements Filter {

    //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    //过滤器执行
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤器执行");
    }

    //销毁
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
