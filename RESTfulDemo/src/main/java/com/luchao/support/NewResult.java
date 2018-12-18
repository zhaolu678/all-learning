package com.luchao.support;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luchao.entity.Goods;

import java.util.Date;
import java.util.Map;

public class NewResult {
    private int code = 200;// 状态码
    private String msg = "";// 错误信息
    private JSONObject data;
    private Goods goods;
    private long timestamp;// 时间戳

    NewResult(){}

    public NewResult(int code, String msg, Goods goods, long timestamp) {
        this.code = code;
        this.msg = msg;
        this.goods = goods;
        this.timestamp = timestamp;
    }

    public NewResult(int code, String msg, JSONObject data, long timestamp) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = timestamp;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    public Goods getGoods() {
        return goods;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static NewResult success(JSONObject jsonObject) {
        NewResult result = new NewResult();
        result.setData(jsonObject);
        result.setCode(200);
        result.setTimestamp(new Date().getTime());
        return result;
    }
    public static NewResult sucess(Goods goods){
        NewResult result = new NewResult();
        result.setCode(200);
        result.setGoods(goods);
        result.setTimestamp(new Date().getTime());
        return result;
    }
    public static NewResult success() {
        NewResult result = new NewResult();
        result.setCode(200);
        result.setTimestamp(new Date().getTime());
        return result;
    }
    public static NewResult error(String msg) {
        NewResult result = new NewResult();
        result.setCode(500);
        result.setMsg(msg);
        result.setTimestamp(new Date().getTime());
        return result;
    }
}
