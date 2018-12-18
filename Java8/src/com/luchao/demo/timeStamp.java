package com.luchao.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeStamp {

	//时间戳转换
	public static void main(String[] args) {
		System.out.println("当前时间戳："+System.currentTimeMillis());
		System.out.println(stampToDate("151263333312"));
	}
	
	/* 
     * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s){
        String res="";
        try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = simpleDateFormat.parse(s);
			long ts = date.getTime();
			res = String.valueOf(ts);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return res;
    }
    
    /* 
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
}
