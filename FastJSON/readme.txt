一、简介

JSONObject {} 对象  .put("","")   .get(key)
    {"QQ":"413425430","Min.score":99,"sex":"男","nickname":"梦中心境","username":"huangwuyi"}
JSONArray [] 数组 .add() .get(i)
    ["this is a jsonArray value","another jsonArray value"]

二、如何从字符串String获得JSONObject对象和JSONArray对象
  JSONObject  jsonObject  = new JSONObject ( String  str);
  JSONArray jsonArray = new JSONArray(String    str  ) ;

   JSON.parseObject(goods.toString()))
   JSON.parse[xxxxxx]()
三、pom.xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.24</version>
</dependency>

参考：https://www.cnblogs.com/xuanbo/p/6913585.html

