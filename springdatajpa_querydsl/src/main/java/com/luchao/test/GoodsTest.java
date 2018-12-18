package com.luchao.test;

import com.luchao.dao.GoodsRepository;
import com.luchao.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsTest {

    @Autowired(required = true)
    private GoodsRepository goodsRepository;

    @Test
    public void getGoods() {
        List<Goods> list = goodsRepository.findGoodsByNameLike("%7%");
        Goods goods = goodsRepository.findGoodsById(10);
        System.out.println("=====" + list.size());
        System.out.println("=====" + goods.toString());
        System.out.println("=====all:" + goodsRepository.findAll().size());
        List<Goods> list1 = goodsRepository.findzdy(99.0);
        System.out.println("=====自定义SQL：" + list1.size());
        List<Goods> list2 = goodsRepository.finddzyys(111);
        System.out.println("=====自定义原生SQL：" + list2.size());
    }

    @Test
    public void saveGoods() {
        Goods goods = new Goods();
        goods.setName("jpatest");
        goods.setPrice(11.99);
        goodsRepository.save(goods);
        System.out.println("===保存成功！");
    }

    @Test
    @Transactional
    @Rollback(false)
    public void deleteGoods() {
        Goods goods = new Goods();
        goods.setId(36);
        //goodsRepository.delete(goods);
        //使用自定义SQL进行删除
        goodsRepository.delzdy(35);
        System.out.println("===删除成功！");

    }

    @Test
    public void updateGoods() {
        Goods goods = new Goods();
        goods.setId(34);
        goods.setName("修改后");
        goods.setPrice(99.89);
        goodsRepository.save(goods);
        System.out.println("===修改成功！");
    }
}
