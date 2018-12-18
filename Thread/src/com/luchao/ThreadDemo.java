package com.luchao;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.junit.Test;

@WebListener	
public class ThreadDemo implements ServletContextListener{
	
	int i=1;
	long ontime = 3000L;//间隔时间
	
	//需求：有一个操作数据库的方法。当方法执行结束后60秒重新执行再执行方法。
	@Test
	public void test(){
		getInfoToDB();
	}
	
	/**
	 * 查询到接口返回的数据，并入库。
	 */
	private synchronized void getInfoToDB() {
		System.out.println("开始执行");
		long begintime = System.currentTimeMillis();
		System.out.println("查询数据");
		System.out.println("存入数据库");
		System.out.println("执行结束");
		long endtime = System.currentTimeMillis();
		System.out.println("本次执行时间"+(begintime-endtime)+"毫秒");
		System.out.println("----------第"+i+"次执行完成,"+ontime+"毫秒后将执行下一次同步--------------");
		i++;
		try {
			Thread.sleep(ontime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		getInfoToDB();
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("===========================MyServletContextListener初始化");
		System.out.println(sce.getServletContext().getServerInfo());
		getInfoToDB();
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		 System.out.println("===========================MyServletContextListener销毁");
		
	}

}