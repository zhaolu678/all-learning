package com.luchao.springbootswager.util;


import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {

    public static String HttpPostWithJson(String url, String json) {
        String returnValue = "接口调用失败";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            //第一步：创建HttpClient对象
            httpClient = HttpClients.createDefault();

            //第二步：创建httpPost对象
            HttpPost httpPost = new HttpPost(url);

            //第三步：给httpPost设置JSON格式的参数
            StringEntity requestEntity = new StringEntity(json, "utf-8");
            requestEntity.setContentEncoding("UTF-8");
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setEntity(requestEntity);

            //第四步：发送HttpPost请求，获取返回值
            returnValue = httpClient.execute(httpPost, responseHandler); //调接口获取返回值时，必须用此方法

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //第五步：处理返回值
        return returnValue;
    }

    public static String HttpGet(String url) {
        String returnValue = "接口调用失败";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {

            //创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            //执行调用
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                //返回值
                returnValue = EntityUtils.toString(httpResponse.getEntity());//获得返回的结果
                System.out.println(returnValue);
            } else {
                returnValue=httpResponse.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return returnValue;
    }

//    public static void main(String[] args) {
//        String urlstr = "http://moa.sgai.com.cn/interface/sgjt/i3/sec/auth";
//        String parms = "{\n" +
//                "  \"modelName\": \"SM-G9350\",\n" +
//                "  \"productName\": \"xxx\",\n" +
//                "  \"osVersion\": \"5.1.1\",\n" +
//                "  \"osName\": \"Android\",\n" +
//                "  \"platform\": \"android\",\n" +
//                "  \"deviceId\": \"af461b41fcbc8e1d\",\n" +
//                "  \"udid\": \"4025043635627879\",\n" +
//                "  \"longitude\": 121.48789833333333,\n" +
//                "  \"latitude\": 31.24916,\n" +
//                "  \"appVersion\": \"3.6.51\",\n" +
//                "  \"j_username\": \"ces5555\",\n" +
//                "  \"j_ecode\":\"sgjt\",\n" +
//                "  \"j_password\": \"111111\"\n" +
//                "}";
//        String rv = HttpPostWithJson(urlstr, parms);
//        System.out.println(rv);

//        String urlstr = "http://moa.sgai.com.cn/interface/sgjt/p/work/stats?usertoken=NTkwYTlhOTEyMTE2MTgxNjc3NTc3ZWUyQDE1NjIwN0A1YjNjOWEyYjE0ZWE0MmYyZjBhOGFlM2JAMTU0MzU0NTA4Njk1Ng==";
//        String rv = HttpGet(urlstr);
//        System.out.println(rv);
//    }

}
