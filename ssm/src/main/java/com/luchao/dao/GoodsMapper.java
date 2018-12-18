package com.luchao.dao;

import com.luchao.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {
    /**
     * 获取所有商品信息并分页
     */
    public List<Goods> getAllGoodsPager(@Param("skip") int skip,@Param("size") int size);

    public List<Goods> searchGoodsPager(@Param("sname") String sname,@Param("skip") int skip,@Param("size") int size);
    /**
     * 获得单个商品通过编号
     */
    public Goods getGoodsById(int id);
    /**
     * 获得商品总数
     */
    public int getGoodsCount();
    /*
     * 新增加商品
     */
    public int addGoods(Goods goods);
    /**
     * 删除商品
     */
    public int deleteGoodsById(int id);
    /**
     * 修改商品
     */
    public int updateGoods(Goods goods);
}
