package com.luchao.test;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class test {
	
	public static void main(String[] args) {
		
		 try {
			String a = "����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�";//编码
			String bString=new String(a.getBytes("gbk"),"utf-8");
			System.out.println(bString);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
