package com.qf.j2112.service;

import com.qf.j2112.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    int addGoods(Goods goods);
    List<Goods> findByState( Goods goods);

    boolean updateGoodState(Goods goods);
    boolean updateEndGoodState(Goods goods);

    boolean updateGetGoodState(Goods goods);
}
