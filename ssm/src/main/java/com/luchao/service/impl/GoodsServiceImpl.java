package com.luchao.service.impl;

import com.luchao.dao.GoodsMapper;
import com.luchao.pojo.Goods;
import com.luchao.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> getAllGoodsPager(int skip, int size) {
        return goodsMapper.getAllGoodsPager(skip,size);
    }

    @Override
    public List<Goods> searchGoodsPager(String sname, int skip, int size) {
        return goodsMapper.searchGoodsPager(sname,skip,size);
    }

    @Override
    public Goods getGoodsById(int id) {
        return goodsMapper.getGoodsById(id);
    }

    @Override
    public int getGoodsCount() {
        return goodsMapper.getGoodsCount();
    }

    @Override
    public int addGoods(Goods goods) {
        return goodsMapper.addGoods(goods);
    }

    @Override
    public int deleteGoodsById(int id) {
        return goodsMapper.deleteGoodsById(id);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateGoods(goods);
    }
}
