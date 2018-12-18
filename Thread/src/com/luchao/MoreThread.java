package com.luchao;

import org.junit.Test;

public class MoreThread{
	
	/**
	 * 多线程
	 * @throws InterruptedException
	 */
	@Test
	public void test1() throws InterruptedException {
		//创建3个线程
		Thread t1 = new ThreadTest("t1", 1000);  
        Thread t2 = new ThreadTest("t2", 3000);  
        Thread t3 = new ThreadTest("t3", 5000);  
        //设置线程的优先级（并不是起作用）
        t2.setPriority(10);
        t1.setPriority(7);
        t3.setPriority(3);
        
        //分别启动线程
        t1.start();  
        System.out.println(t1.getState());
        t2.start();  
        t3.start();  
        System.out.println(t1.getState());
        System.out.println(t1.getState());
        System.out.println(t1.getState());
        System.out.println(t1.getState());
        //主线程休眠2秒中后，打印出个线程的状态
        Thread.sleep(2000L);
        System.out.println(t1.getState());
        System.out.println(t2.getState());
        System.out.println(t3.getState());
	}
	
	
	class ThreadTest extends Thread{  
        private String name;  
        private int ms;  
        public ThreadTest(String name, int ms) {  
            this.name = name;  
            this.ms = ms;  
        }  
        public void run(){  
            try {  
            	System.out.println("名称为："+name+",线程休眠："+ms+"毫秒");  
                sleep(ms);  
            } catch (Exception e) {  
            	System.out.println("线程中断异常");  
            }  
        }  
    }  
	
}
