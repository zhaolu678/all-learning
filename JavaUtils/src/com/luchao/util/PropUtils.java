package com.luchao.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class PropUtils {
	
	protected static Logger log = Logger.getLogger(PropUtils.class);
	
	private static Properties prop = new Properties();
	
	static {
		try {
			prop.load(PropUtils.class.getClassLoader().getResourceAsStream("config/fmall.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPropString(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}
	
	public static String getPropStringEncoded(String key) {
		String val = prop.getProperty(key, "");
		try {
			return new String(val.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPropString(String key) {
		return prop.getProperty(key);
	}
	
	public static Integer getPropInteger(String key, Integer defaultValue) {
		String value = getPropString(key);
		if(value == null) {
			return defaultValue;
		}
		
		return null;
	}
	
	public static Integer getPropInteger(String key) {
		String value = getPropString(key);
		if(value != null) {
			try {
				return Integer.valueOf(value);
			} catch(Exception e) {
				log.error("getPropInteger error: ", e);
			}
		}
		
		return null;
	}

}
