package com.luchao.test;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * 解析获取JSON数据
 */
public class FastJSONDemo {
	
	public static void main(String[] args) {
		String string = "{\"info\":{\"status\":\"SUCCESS\"},\"data\":{\"isOaUser\":true,\"gender\":\"MALE\",\"phone\":\"\",\"icon\":\"http://apptest.sggf.com.cn:8801/defaultroot/upload/peopleinfo/2017071210005832078600687.jpg\",\"name\":\"赵路\",\"duty\":\"员工\",\"employeeId\":\"126490\",\"departmentHierarchy\":\"首钢集团/OA运维项目组\",\"job\":\"员工\",\"cellPhone\":\"\",\"username\":\"zhaol3317\"}}";
//		String string = "{\"info\":{\"status\":\"SUCCESS\"},\"data\":{\"isOaUser\":true,\"gender\":\"MALE\"}}";
		 
		JSONObject hostObject = JSONObject.parseObject(string);
		Map<String, String> map =(Map<String, String>) hostObject.get("info");
		Map<String, String> map2 =(Map<String, String>)hostObject.get("data");
		System.out.println(map2.get("username"));
		
		String string2 = "{\"code\":403,\"msg\":\"用户已在其他设备上登录，请重新登录\",\"token\":1512550962844}";
		JSONObject jObject = JSONObject.parseObject(string2);
		Object ob = jObject.get("code");
		if(null!=ob){
			System.out.println(ob.toString());
		}


	}

}
