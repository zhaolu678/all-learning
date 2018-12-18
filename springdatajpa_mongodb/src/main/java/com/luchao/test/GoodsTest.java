package com.luchao.test;

import com.luchao.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void getGoods() {
        List<Goods> list = mongoTemplate.findAll(Goods.class);
        System.out.println("===" + list.size());
        for (int i = 0; i < list.size(); i++) {
            Goods goods = list.get(i);
            System.out.println(goods.getId() + "=====" + goods.getCreateDate());
        }
        Query query = new Query();
        //query.addCriteria(Criteria.where("parent").is(null));
        //价格小于50的
        query.addCriteria(Criteria.where("price").lt(50));
        //query.addCriteria(Criteria.where("name").is("aaaaaa"));
        List<Goods> newlist = mongoTemplate.find(query, Goods.class);
        System.out.println("---"+newlist.size());
        for (int i = 0; i < newlist.size(); i++) {
            Goods goods = newlist.get(i);
            System.out.println(goods.getName() + "=====" + goods.getPrice());
        }
    }

    @Test
    public void saveGoods() {
        for (int i=0;i<10;i++){
            Goods g = new Goods();
            g.setName("aaaa"+i);
            g.setPrice(Math.random()*100);
            g.setPicture("xxxxx");
            g.setCreateDate(new Date());
            mongoTemplate.save(g);
        }
        System.out.println("===保存成功！");
    }

    @Test
    public void deleteGoods() {
        Goods goods = new Goods();
        goods.setId("5bab206e90ec1379a2f25884");
        mongoTemplate.remove(goods);
        Query query = Query.query(Criteria.where("id").is("5bab206f90ec1379a2f25887"));
        mongoTemplate.remove(query,Goods.class);
        System.out.println("===删除成功！");
    }

    @Test
    public void updateGoods() {
        Query query=new Query(Criteria.where("id").is("5bab206f90ec1379a2f25889"));
        Update update = Update.update("name", "009");
        //修改第一条
        mongoTemplate.updateFirst(query, update, Goods.class);
        //当没有符合条件的文档，就以这个条件和更新文档为基础创建一个新的文档，如果找到匹配的文档就正常的更新。
        mongoTemplate.upsert(query, update, Goods.class);
        //修改全部符合条件的
        mongoTemplate.updateMulti(query,update,Goods.class);
        System.out.println("===修改成功！");
    }


}
