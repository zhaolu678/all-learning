package com.luchao.dao;

import com.luchao.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long> {
    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<Goods> findGoodsByNameLike(String name);
    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
    Goods findGoodsById(int id);

    /**
     * 自定义sql查询：
     * @param price
     * @return
     */
    @Query("SELECT good FROM Goods as good where price>:price")
    List<Goods> findzdy(@Param("price") double price);

    @Modifying
    @Transactional
    @Query("DELETE FROM Goods where id = :id")
    void delzdy(@Param("id") int id);

    @Query(value = "SELECT good.* FROM goods as good where price>:price", nativeQuery = true)
    List<Goods> finddzyys(@Param("price") double price);
}
