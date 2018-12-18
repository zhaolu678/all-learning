package com.luchao.springboot.controller;

import com.luchao.springboot.collection.SanliukeCollection;
import com.luchao.springboot.collection.SinaCollection;
import com.luchao.springboot.collection.ToutiaoCollection;
import com.luchao.springboot.pojo.News;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class NewsController {

    @Value("${news.auth}")
    public String auth;
    @Value("${news.backgroundimage}")
    public String backgroundimage;

    @RequestMapping("/")
    public String toindex(){
        return  "index";
    }
    @RequestMapping("/news/{type}")
    public String getNewsByType(Model model,@PathVariable String type){
        List<News> newlist = new ArrayList<News>();
        String ret = "news_sina";
        model.addAttribute("type",type);
        if(type.equals("toutiao")){
            newlist = ToutiaoCollection.getToutiaoNews();
            ret = "news_toutiao";
        }else if(type.equals("36ke")){
            newlist = SanliukeCollection.getSanliukeNews();
            ret = "news_36ke";
        }else if(type.equals("sina")){
            newlist = SinaCollection.getSinaNews();
            ret = "news_sina";
        }else {//默认返回
            newlist = SinaCollection.getSinaNews();
            model.addAttribute("type","sina");
            ret = "news_sina";
        }
        model.addAttribute("auth",auth);
        model.addAttribute("backgroundimage","../"+backgroundimage);
        model.addAttribute("newlist",newlist);
        model.addAttribute("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return ret;
    }

}
