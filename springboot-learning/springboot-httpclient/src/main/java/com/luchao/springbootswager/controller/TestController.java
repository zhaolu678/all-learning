package com.luchao.springbootswager.controller;

import com.alibaba.fastjson.JSONObject;
import com.luchao.springbootswager.util.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String toindex() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String tologin(Model model, String menhuurl, String uname, String upassword, String ecode) {
        String parms = "{\n" +
                "  \"modelName\": \"SM-G9350\",\n" +
                "  \"productName\": \"test function\",\n" +
                "  \"osVersion\": \"5.1.1\",\n" +
                "  \"osName\": \"Android\",\n" +
                "  \"platform\": \"android\",\n" +
                "  \"deviceId\": \"af461b41fcbc8e1d\",\n" +
                "  \"udid\": \"4025043635627879\",\n" +
                "  \"longitude\": 121.48789833333333,\n" +
                "  \"latitude\": 31.24916,\n" +
                "  \"appVersion\": \"3.6.51\",\n" +
                "  \"j_username\": \"" + uname + "\",\n" +
                "  \"j_ecode\":\"" + ecode + "\",\n" +
                "  \"j_password\": \"" + upassword + "\"\n" +
                "}";
        long starttime = System.currentTimeMillis();
        String returnstr = HttpUtil.HttpPostWithJson(menhuurl + ecode + "/i3/sec/auth", parms);
        long endtime = System.currentTimeMillis();
        System.out.println("loginresult:"+returnstr);
        if (!returnstr.equals("接口调用失败")) {
            //截取Usertoken，放入model返回
            JSONObject hostObject = JSONObject.parseObject(returnstr);
            String code = hostObject.getString("code");

            if (null != code && !code.equals("") && code.equals("200")) {
                Map<String, String> map = (Map<String, String>) hostObject.get("result");
                model.addAttribute("usertoken", map.get("usertoken"));
                JSONObject baseObject = hostObject.getJSONObject("result");
                JSONObject userinfoObject = baseObject.getJSONObject("userInfo");
                String name = (String) userinfoObject.get("name");
                String department = (String) userinfoObject.get("department");
                model.addAttribute("name", name);
                model.addAttribute("department", department);
                model.addAttribute("logintotaltime", "总共：" + (endtime - starttime) + "毫秒/总共：" + (endtime - starttime) / 1000 + "." + (endtime - starttime) % 1000 + "秒");
                model.addAttribute("loginresult", returnstr);
            } else {
                model.addAttribute("loginresult", returnstr);
            }
        }else {
            model.addAttribute("loginresult", "接口调用失败！可能服务器请求超时了。");
        }

        model.addAttribute("menhuurl", menhuurl);
        model.addAttribute("uname", uname);
        model.addAttribute("upassword", upassword);
        model.addAttribute("ecode", ecode);
        return "index";
    }

    @RequestMapping(value = "/getuserstats", method = RequestMethod.POST)
    public String getuserstats(Model model, String menhuurl, String usertoken, String ecode, String uname, String upassword, String name, String department) {
        System.out.println("=============" + usertoken);
        String urlstr = menhuurl + ecode + "/p/work/stats?usertoken=" + usertoken;
        //根据URL,usertoken获取待办数
        long starttime = System.currentTimeMillis();
        String str = HttpUtil.HttpGet(urlstr);
        long endtime = System.currentTimeMillis();
        model.addAttribute("name", name);
        model.addAttribute("department", department);
        model.addAttribute("menhuurl", menhuurl);
        model.addAttribute("uname", uname);
        model.addAttribute("upassword", upassword);
        model.addAttribute("ecode", ecode);
        model.addAttribute("usertoken", usertoken);
        model.addAttribute("userstatsresult", str);
        model.addAttribute("userstatstime", "总共：" + (endtime - starttime) + "毫秒/总共：" + (endtime - starttime) / 1000 + "." + (endtime - starttime) % 1000 + "秒");
        return "index";
    }

    @RequestMapping(value = "/getaccanduinfo", method = RequestMethod.POST)
    public String getaccanduinfo(Model model, String menhuurl, String usertoken, String ecode, String appid, String secretkey, String uname, String upassword) {
//http://moa.sgai.com.cn/interface/sgjt/i1/oauth/getaccesstoken?appid=touzi&secretkey=68b870d0af8e40ae76d1ade1be0c3c51&ecode=sgjt

        //获取accesstoken
        String accesstokenurl = menhuurl + ecode + "/i1/oauth/getaccesstoken?appid=" + appid + "&secretkey=" + secretkey + "&ecode=" + ecode;
        long accesstokenstarttime = System.currentTimeMillis();
        String accesstokenstr = HttpUtil.HttpGet(accesstokenurl);
        long accesstokenendtime = System.currentTimeMillis();

        JSONObject hostObject = JSONObject.parseObject(accesstokenstr);
        String code = hostObject.getString("code");

        Map<String, String> map = (Map<String, String>) hostObject.get("data");
        if (null != map) {
            String accesstoken = map.get("accesstoken");
            //http://moa.sgai.com.cn/interface/sgjt/i1/oauth/userinfo?accesstoken=c2dqdEA1YTllNTE0YTE0ZWE1MDI2MDBiNGI3ZWVAMTU0MzU1MDM3OA==&usertoken=NTkwYTlhOTEyMTE2MTgxNjc3NTc3ZWUyQDE1NjIwN0A1YjNjOWEyYjE0ZWE0MmYyZjBhOGFlM2JAMTU0MzU0OTYzNTEyMg==

            //获取用户信息
            String getuserinfourl = menhuurl + ecode + "/i1/oauth/userinfo?accesstoken=" + accesstoken + "&usertoken=" + usertoken;
            long getuserinfourlstarttime = System.currentTimeMillis();
            String getuserinfostr = HttpUtil.HttpGet(getuserinfourl);
            long getuserinfourlendtime = System.currentTimeMillis();

            model.addAttribute("getuserinfostr", getuserinfostr);
            model.addAttribute("getuserinfototaltime", "总共：" + (getuserinfourlendtime - getuserinfourlstarttime) + "毫秒/总共：" + (getuserinfourlendtime - getuserinfourlstarttime) / 1000 + "." + (getuserinfourlendtime - getuserinfourlstarttime) % 1000 + "秒");
            model.addAttribute("accesstokenstr", accesstokenstr);
        }
        model.addAttribute("accesstokenstr", accesstokenstr);
        model.addAttribute("acctotaltime", "总共：" + (accesstokenendtime - accesstokenstarttime) + "毫秒/总共：" + (accesstokenendtime - accesstokenstarttime) / 1000 + "." + (accesstokenendtime - accesstokenstarttime) % 1000 + "秒");

        model.addAttribute("menhuurl", menhuurl);
        model.addAttribute("uname", uname);
        model.addAttribute("upassword", upassword);
        model.addAttribute("ecode", ecode);
        model.addAttribute("usertoken", usertoken);
        model.addAttribute("appid", appid);
        model.addAttribute("secretkey", secretkey);
        return "index";
    }

    //查询每个栏目下的新闻列表
    //http://app.sggf.com.cn/interface/shouganggufen/i/news/query.page?channelId=23683&usertoken=NTkxMDU5MDcyNjUyYjdlMjBhNTQ4MzYyQDE1ODYyMDdANWMwNDliZDQyNjUyNGE5NGQ0ODNiNzQ5QDE1NDM4MDg5NTAyMjk=
    @RequestMapping(value = "/getnewsinfobychannelid", method = RequestMethod.POST)
    public String getnewsinfobychannelid(Model model, String menhuurl, String usertoken, String ecode, String channelid, String uname, String upassword) {
        String strurl = menhuurl + ecode + "/i/news/query.page?channelId=" + channelid + "&usertoken=" + usertoken;
        long getnewsinfobychannelidstarttime = System.currentTimeMillis();
        String getnewsresult = HttpUtil.HttpGet(strurl);
        long getnewsinfobychannelidendtime = System.currentTimeMillis();

        model.addAttribute("getnewsresult", getnewsresult);
        model.addAttribute("getuserinfototaltime", "总共：" + (getnewsinfobychannelidendtime - getnewsinfobychannelidstarttime) + "毫秒/总共：" + (getnewsinfobychannelidendtime - getnewsinfobychannelidstarttime) / 1000 + "." + (getnewsinfobychannelidendtime - getnewsinfobychannelidstarttime) % 1000 + "秒");
        model.addAttribute("uname", uname);
        model.addAttribute("upassword", upassword);
        model.addAttribute("channelid", channelid);
        model.addAttribute("menhuurl", menhuurl);
        model.addAttribute("ecode", ecode);
        model.addAttribute("usertoken", usertoken);
        return "index";
    }
}
