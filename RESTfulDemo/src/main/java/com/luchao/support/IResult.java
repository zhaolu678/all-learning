package com.luchao.support;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * [返回结果对象]
 *
 */
public class IResult {
	private int code = 200;// 状态码
	private String msg = "";// 错误信息
	private Map data = new HashMap();// 返回数据
	private long timestamp;// 时间戳

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public static IResult success(Map obj) {
		IResult result = new IResult();
		result.setData(obj);
		result.setCode(200);
		result.setTimestamp(new Date().getTime());
		return result;
	}
	public static IResult success() {
		IResult result = new IResult();
		result.setCode(200);
		result.setTimestamp(new Date().getTime());
		return result;
	}
	public static IResult error(String msg) {
		IResult result = new IResult();
		result.setCode(500);
		result.setMsg(msg);
		result.setTimestamp(new Date().getTime());
		return result;
	}

}
