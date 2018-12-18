package com.luchao.test;

import com.luchao.dao.GoodsRepository;
import com.luchao.entity.Goods;
import com.luchao.entity.QGoods;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Component
public class QueryDslTest {

    @Autowired(required = true)
    private GoodsRepository goodsRepository;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @PostConstruct
    public void init() {//初始化queryFactory
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Test
    public void getGoods() {
        QGoods qGoods = QGoods.goods;
        Iterable<Goods> iterable = goodsRepository.findAll(qGoods.name.eq("博微移动办公"));
        System.out.println(iterable.getClass());
        iterable.forEach(goods -> System.out.println("===" + goods.getName()));
        //使用Predicate
        Predicate predicate = qGoods.name.eq("博微移动办公");
        Goods goods = goodsRepository.findOne(predicate);
        System.out.println("====" + goods.toString());
    }

    //使用BooleanBuilder查询
    @Test
    public void getGoodsForBooleanBuilder() {
        QGoods qGoods = QGoods.goods;
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC, "price"));
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        booleanBuilder.and(qGoods.price.gt(66.9));
        booleanBuilder.and(qGoods.picture.isNotNull());
//        List<Goods> list = (List<Goods>) goodsRepository.findAll(booleanBuilder);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName());
//        }
        Iterable<Goods> iterable = goodsRepository.findAll(booleanBuilder, sort);
        iterable.forEach(g -> System.out.println("====" + g.getName()));
    }

    /**
     * queryFactory/jpa 修改，删除
     */

    @Test
    @Modifying
    @Transactional(rollbackFor = RuntimeException.class,readOnly=false,noRollbackFor=RuntimeException.class,isolation = Isolation.DEFAULT)
    public void updateGoods() {
        QGoods qGoods = QGoods.goods;
        //使用Predicate
        Predicate predicate = qGoods.name.eq("博微移动办公");
        Goods goods = goodsRepository.findOne(predicate);
        System.out.println("====="+goods.getName());
        //初始化queryFactory 未成功
        queryFactory.delete(QGoods.goods).where(QGoods.goods.id.eq(35)).execute();
//        entityManager.flush();
//        entityManager.getTransaction().commit();

        //JPA删除操作.事务不能多处使用。可能导致事务未提交。
//        Goods goods = new Goods();
//        goods.setId(38);
//        goodsRepository.delete(goods);

    }

    //使用JPAQueryFactory查询
    @Test
    @Modifying
    public void getGoodsTable() {
        QGoods qGoods = QGoods.goods;
        //初始化queryFactory
//        queryFactory = new JPAQueryFactory(entityManager);
        //查询
        //List<Integer> list = queryFactory.select(QGoods.goods.id).from(QGoods.goods).fetch();
        //System.out.println("===="+list.size());
        //查询
//        JPAQuery<Tuple> jpaQuery =  queryFactory.select(QGoods.goods.id,QGoods.goods.name).from(QGoods.goods).where(QGoods.goods.id.eq(29));
//        Tuple t = jpaQuery.fetchOne();
//        System.out.println(t); //返回结果：[29, 博微移动办公]

        //update 未成功
        JPAUpdateClause jpaUpdateClause = queryFactory.update(qGoods).set(qGoods.name, "20180903").where(qGoods.id.eq(29));
        long l = jpaUpdateClause.execute();
        System.out.println("===执行了：" + l); //问题：数据库中未提交
        //delete 未成功
        //queryFactory.delete(qGoods).where(qGoods.id.eq(34)).execute();

    }


}
