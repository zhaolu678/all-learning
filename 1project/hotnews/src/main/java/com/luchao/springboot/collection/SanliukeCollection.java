package com.luchao.springboot.collection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luchao.springboot.pojo.News;
import com.luchao.springboot.util.HttpUtil;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class SanliukeCollection {

    /**
     * 获取36氪快讯，获取20条。
     * https://36kr.com/newsflashes
     * @return
     */
    public static List<News> getSanliukeNews() {
        List<News> list = new ArrayList<>();
        String sturl = "https://36kr.com/newsflashes";
        String result = HttpUtil.HttpGet(sturl);
        result = "{"+result.substring(result.indexOf("\"newsflashList|newsflash\":"), result.indexOf("}],\"hotPosts|hotPost\":")+2)+"}";
        result = result.replace("\\\"","");
        result = result.replace("\\","");
        JSONObject hostObject = JSONObject.parseObject(result);
        JSONArray jsonArray = hostObject.getJSONArray("newsflashList|newsflash");
        for (int i = 0; i < jsonArray.size(); i++) {
            News news = new News();
            JSONObject newsObject =  jsonArray.getJSONObject(i);
            news.setName(newsObject.get("title")+"");
            news.setLink(newsObject.get("news_url")+"");
            news.setBurst_time(newsObject.get("created_at")+"");
            news.setDescription(newsObject.get("description")+"");
            list.add(news);
        }
        return list;
    }

//    public static void main(String[] args) {
//        List<News> list = new ArrayList<>();
//        String sturl = "https://36kr.com/newsflashes";
//        String result = HttpUtil.HttpGet(sturl);
//        result = "{"+result.substring(result.indexOf("\"newsflashList|newsflash\":"), result.indexOf("}],\"hotPosts|hotPost\":")+2)+"}";
//        result = result.replace("\\\"","");
//        result = result.replace("\\","");
//        System.out.println(result);
//        JSONObject hostObject = JSONObject.parseObject(result);
//        JSONArray jsonArray = hostObject.getJSONArray("newsflashList|newsflash");
//        System.out.println(jsonArray);
//        for (int i = 0; i < jsonArray.size(); i++) {
//            News news = new News();
//            JSONObject newsObject =  jsonArray.getJSONObject(i);
//            news.setName(newsObject.get("title")+"");
//            news.setLink(newsObject.get("news_url")+"");
//            news.setBurst_time(newsObject.get("created_at")+"");
//            news.setDescription(newsObject.get("description")+"");
//            list.add(news);
//        }
//        System.out.println(jsonArray.size());
//    }

//    public static void main(String[] args) {
//        List list= new SinaCollection().getSinaNews();
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }
//    }

}
