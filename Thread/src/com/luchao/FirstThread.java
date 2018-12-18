package com.luchao;

import org.junit.Test;

public class FirstThread{
	
	/**
	 * 单线程
	 */
	@Test
	public void test1() {
		Thread thread = Thread.currentThread();  
        thread.setName("单线程");  
        System.out.println(thread.getState());
        System.out.println(thread.getName()+"正在运行");  
        for (int i = 0; i < 10; i++) {  
            System.out.println(thread.getName()+"正在休眠："+i);  
            try {  
                thread.sleep(500);  
            } catch (Exception e) {  
                e.printStackTrace();  
                System.out.println("线程出现错误！");  
            }  
        }  
        System.out.println(thread.getState());
	}
	
	
	public static void main(String[] args) {
		TERMINATED();
		System.out.println(Thread.activeCount());
	}
	@Test
   private static void TERMINATED() {
         Thread t1 = new Thread();
         t1.start();
         System. out.println(t1.getState());
          try {
             Thread. sleep(1000L);
         } catch (InterruptedException e) {
         }
          System. out.println(t1.getState());
    }
}
