package com.luchao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitDataListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听器初始化完毕！");

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听器销毁！");
    }
}
