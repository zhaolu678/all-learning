package com.luchao.springboot.collection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luchao.springboot.pojo.News;
import com.luchao.springboot.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;


public class ToutiaoCollection {

    /**
     * 获取新今日头条，头条热搜；获取30条。
     * https://www.toutiao.com/2/wap/search/extra/hot_word_list/?from=toutiao_pc&is_new_ui=1
     * @return
     */
    public static List<News> getToutiaoNews() {
        List<News> list = new ArrayList<>();
        String sturl = "https://www.toutiao.com/2/wap/search/extra/hot_word_list/?from=toutiao_pc&is_new_ui=1";
        String result = HttpUtil.HttpGet(sturl);
        result = result.replace("\\","");
        result = result.substring(result.indexOf("{\"search_words\":"), result.indexOf("}]}")+3 );
        JSONObject hostObject = JSONObject.parseObject(result);
        JSONArray jsonArray = hostObject.getJSONArray("search_words");
        for (int i = 0; i < jsonArray.size(); i++) {
            News news = new News();
            JSONObject newsObject =  jsonArray.getJSONObject(i);
            news.setName(newsObject.get("q")+"");
            news.setBurst_time("");
            news.setEmoticon("");
            news.setWord("");
            news.setLink("https://www.toutiao.com/search/?keyword="+newsObject.get("q")+"&from=gs_hotlist");
            list.add(news);
        }
        return list;
    }

//    public static void main(String[] args) {
//        List<News> list = new ArrayList<>();
//        String sturl = "https://www.toutiao.com/2/wap/search/extra/hot_word_list/?from=toutiao_pc&is_new_ui=1";
//        String result = HttpUtil.HttpGet(sturl);
//        //System.out.println(result);
//        //String j = "try{window.&({\"data\":{\"top\":{\"word\":\"\\u5341\\u5927\\u4e8b\\u6545\\u591a\\u53d1\\u957f\\u4e0b\\u5761\\u8def\\u6bb5\",\"is_ad\":0},\"list\":[{\"note\":\"\\u738b\\u73c2 \\u5218\\u6d9b\",\"word\":\"#\\u738b\\u73c2 \\u5218\\u6d9b#\",\"mid\":\"4317300787865945\",\"is_fei\":1,\"num\":\"1793229\",\"ai\":\"0\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 07:03\",\"total_number\":\"A\",\"friend\":\"8\",\"emoticon\":\"[\\u6cea]\",\"realpos\":0,\"flag\":16},{\"note\":\"\\u6c38\\u8f89\\u8d85\\u5e02\\u521b\\u59cb\\u4eba\\u4e24\\u5144\\u5f1f\\u5206\\u6b67\",\"word\":\"#\\u6c38\\u8f89\\u8d85\\u5e02\\u521b\\u59cb\\u4eba\\u4e24\\u5144\\u5f1f\\u5206\\u6b67#\",\"mid\":\"4317426566850887\",\"is_hot\":1,\"num\":\"1429057\",\"ai\":\"5\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 09:33\",\"total_number\":\"A\",\"friend\":\"32\",\"emoticon\":\"\",\"realpos\":1,\"flag\":2},{\"note\":\"\\u5ef6\\u79a7\\u653b\\u7565\\u7248\\u6743\\u535690\\u56fd\",\"word\":\"#\\u5ef6\\u79a7\\u653b\\u7565\\u7248\\u6743\\u535690\\u56fd#\",\"mid\":\"4317404345450679\",\"num\":\"1079208\",\"ai\":\"1\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 08:52\",\"total_number\":\"A\",\"friend\":\"524288\",\"emoticon\":\"\",\"realpos\":2,\"flag\":0},{\"note\":\"\\u4e8c\\u6708\\u6cb3\\u53bb\\u4e16\",\"word\":\"#\\u4e8c\\u6708\\u6cb3\\u53bb\\u4e16#\",\"mid\":\"4317428097563155\",\"is_new\":1,\"num\":\"1044038\",\"ai\":\"4\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 10:05\",\"total_number\":\"A\",\"friend\":\"16\",\"emoticon\":\"[\\u8721\\u70db]\",\"realpos\":3,\"flag\":1},{\"note\":\"\\u661f\\u7235\\u5ba3\\u5e03\\u604b\\u60c5\",\"word\":\"\\u661f\\u7235\\u5ba3\\u5e03\\u604b\\u60c5\",\"mid\":\"4317438730848854\",\"is_new\":1,\"num\":\"1002269\",\"ai\":\"1\",\"topic_flag\":\"0\",\"burst_time\":\"2018-12-15 10:47\",\"total_number\":\"A\",\"friend\":\"4\",\"emoticon\":\"\",\"realpos\":4,\"flag\":1},{\"note\":\"\\u82f9\\u679c\\u8ba1\\u5212\\u5c06\\u8ba2\\u5355\\u8f6c\\u7ed9\\u548c\\u7855\",\"word\":\"\\u82f9\\u679c\\u8ba1\\u5212\\u5c06\\u8ba2\\u5355\\u8f6c\\u7ed9\\u548c\\u7855\",\"mid\":\"4317423497068102\",\"is_new\":1,\"num\":\"766081\",\"ai\":\"1\",\"topic_flag\":\"0\",\"burst_time\":\"2018-12-15 10:21\",\"total_number\":\"A\",\"friend\":\"512\",\"emoticon\":\"\",\"realpos\":5,\"flag\":1},{\"note\":\"\\u56db\\u7ea7\\u4f5c\\u6587\",\"word\":\"#\\u56db\\u7ea7\\u4f5c\\u6587#\",\"mid\":\"4317403217043876\",\"is_fei\":1,\"num\":\"652006\",\"ai\":\"4\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 07:47\",\"total_number\":\"A\",\"friend\":\"16\",\"emoticon\":\"\",\"realpos\":6,\"flag\":16},{\"note\":\"\\u7537\\u5b69\\u5b50\\u957f\\u5f97\\u597d\\u770b\\u5f88\\u5371\\u9669\",\"word\":\"#\\u7537\\u5b69\\u5b50\\u957f\\u5f97\\u597d\\u770b\\u5f88\\u5371\\u9669#\",\"mid\":\"4317439921017920\",\"is_fei\":1,\"num\":\"644958\",\"ai\":\"8\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 07:17\",\"total_number\":\"B\",\"friend\":\"12288\",\"emoticon\":\"\",\"realpos\":7,\"flag\":16},{\"note\":\"\\u56db\\u516d\\u7ea7\",\"word\":\"#\\u56db\\u516d\\u7ea7#\",\"mid\":\"4317403217043876\",\"is_fei\":1,\"num\":\"600858\",\"ai\":\"4\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 07:20\",\"total_number\":\"A\",\"friend\":\"4194304\",\"emoticon\":\"[\\u52a0\\u6cb9]\",\"realpos\":8,\"flag\":16},{\"note\":\"\\u80e1\\u51b0\\u537f\\u5426\\u8ba4diss\\u67d0\\u9ad8\\u6821\\u4e09\\u6d41\",\"word\":\"#\\u80e1\\u51b0\\u537f\\u5426\\u8ba4diss\\u67d0\\u9ad8\\u6821\\u4e09\\u6d41#\",\"mid\":\"4317250880585473\",\"num\":\"562521\",\"ai\":\"1\",\"topic_flag\":\"1\",\"burst_time\":\"2018-12-15 07:47\",\"total_number\":\"A\",\"friend\":\"4\",\"emoticon\":\"\",\"realpos\":9,\"flag\":0}]}});}catch(e){}\n";
//        // System.out.println(result.indexOf("{\"data\":{"));
//        //System.out.println(result.indexOf("}]}}"));
//        //System.out.println(result.substring(result.indexOf("{\"data\":{"), result.indexOf("}]}}")+4));
//        result = result.replace("\\","");
//        //System.out.println(result);
//        result = result.substring(result.indexOf("{\"search_words\":"), result.indexOf("}]}")+3 );
//        System.out.println(result);
//        //String word = "\\u661f\\u7235\\u5ba3\\u5e03\\u604b\\u60c5";
//        //System.out.println(UnicodeUtil.unicodeToCn(word));
//        JSONObject hostObject = JSONObject.parseObject(result);
//        JSONArray jsonArray = hostObject.getJSONArray("search_words");
//        System.out.println(jsonArray);
//        for (int i = 0; i < jsonArray.size(); i++) {
//            News news = new News();
//            JSONObject newsObject =  jsonArray.getJSONObject(i);
//            news.setName(newsObject.get("q")+"");
//            news.setBurst_time("");
//            news.setEmoticon("");
//            news.setWord("");
//            list.add(news);
//        }
//        System.out.println(list.toString());
//    }

//    public static void main(String[] args) {
//        List list= new SinaCollection().getSinaNews();
//        for (int i=0;i<list.size();i++){
//            System.out.println(list.get(i).toString());
//        }
//    }

}
