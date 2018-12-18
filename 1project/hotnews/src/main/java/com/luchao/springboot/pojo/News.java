package com.luchao.springboot.pojo;

import java.io.Serializable;

public class News implements Serializable {
    //标题
    private String name;
    //[微博|36氪].爆发时间
    private String burst_time;
    //话题
    private String word;
    //[微博].表情符号
    private String emoticon;
    //[36氪].链接
    private String link;
    //[36氪].简介
    private String description;
    //[新浪].类型[1:新|2:热|16:沸腾]
    private String flag;
    //[新浪].热搜量
    private String num;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBurst_time() {
        return burst_time;
    }

    public void setBurst_time(String burst_time) {
        this.burst_time = burst_time;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    @Override
    public String toString() {
        return "News{" +
                "name='" + name + '\'' +
                ", burst_time='" + burst_time + '\'' +
                ", word='" + word + '\'' +
                ", emoticon='" + emoticon + '\'' +
                '}';
    }

    public News() {}

    public News(String name, String burst_time, String word, String emoticon) {
        this.name = name;
        this.burst_time = burst_time;
        this.word = word;
        this.emoticon = emoticon;
    }
}
