package com.luchao.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 拼装JSON格式
 */
public class demo {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "huangwuyi");
        jsonObject.put("sex", "男");
        jsonObject.put("QQ", "413425430");
        jsonObject.put("Min.score", new Integer(99));
        jsonObject.put("nickname", "梦中心境");
        System.out.println(jsonObject.toString());

        // 返回一个JSONArray对象
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "this is a jsonArray value");
        jsonArray.add(1, "another jsonArray value");
        System.out.println(jsonArray.toString());

        //手写返回结构
        JSONObject returnjson = new JSONObject();
        returnjson.put("code", "200");
        returnjson.put("msg", "操作成功");
        JSONArray j1 = new JSONArray();
        for (int i = 0; i < 5; i++) {
            JSONObject j = new JSONObject();
            j.put("id", i);
            j.put("name", "name" + i);
            j1.add(j);
        }
        returnjson.put("data", j1);
        returnjson.put("time", "2018808023");

        System.out.println("==" + returnjson.toString());

    }
}
