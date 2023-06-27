package com.qf.j2112.mapper;

import com.qf.j2112.po.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    int addGoods(Goods goods);

    List<Goods> findByState(Goods goods);

    int updateGoodState(Goods goods);

    int updateEndGoodState(Goods goods);

    int updateGetGoodState(Goods goods);
}
