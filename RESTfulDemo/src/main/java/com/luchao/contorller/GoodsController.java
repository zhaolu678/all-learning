package com.luchao.contorller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.luchao.entity.Goods;
import com.luchao.support.IResult;
import com.luchao.support.NewResult;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class GoodsController {
    Map map = new HashedMap();
    GoodsController() {
        map.put("name", "zhangsan");
        map.put("age", "11");
        map.put("like", "black");
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    @ResponseBody
    public IResult getAllInfo() {
        System.out.println("==GET查询所有==");
        return IResult.success(map);
    }

    /**
     * 根据id查询操作
     *
     * @return
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    @ResponseBody
    public IResult getInfoById(@PathVariable("id") int id) {
        System.out.println("====GET根据id查询操作===请求参数：" + id);
        map.put("id",id);
        //手写返回结构
        JSONObject returnjson = new JSONObject();
        return IResult.success(map);

//        JSONArray j1 = new JSONArray();
//        for (int i = 0; i < 5; i++) {
//            JSONObject j = new JSONObject();
//            j.put("id", i);
//            j.put("name", "name" + i);
//            j1.add(j);
//        }
//        returnjson.put("ddd",j1);
//        return NewResult.success(returnjson);

//        Goods goods = new Goods();
//        goods.setId(23);
//        goods.setName("cest");
//        goods.setPrice(34.2);
//        return  NewResult.sucess(goods);
    }

    /**
     * 新增
     * @return
     */
    @RequestMapping(value = "/goods",method = RequestMethod.POST)
    @ResponseBody
    public IResult addInfo(@RequestBody Goods goods,HttpServletRequest request, HttpServletResponse response) {
        System.out.println("+++ADD:==="+goods.toString());
        System.out.println("===保存成功！");
        return IResult.success();
    }

    /**
     * 更新
     * @param goods
     * @return
     */
    @RequestMapping(value = "/goods",method = RequestMethod.PUT)
    @ResponseBody
    public IResult updateInfo(@RequestBody Goods goods){
        System.out.println("===获取到商品信息："+goods.toString());
        System.out.println("修改成功！");
        return IResult.success();
    }

    /**
     * 根据id删除商品
     * @return
     */
    @RequestMapping(value = "/goods/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public IResult deleteINFO(@PathVariable("id") int id){
        System.out.println("===获取到id参数："+id);
        System.out.println("执行删除操作！");
        return IResult.success();
    }


}
