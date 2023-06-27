package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.GoodsMapper;
import com.qf.j2112.po.Goods;
import com.qf.j2112.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public int addGoods(Goods goods) {
        int i = goodsMapper.addGoods(goods);
        return i;
    }

    @Override
    public List<Goods> findByState(Goods goods) {
        List<Goods> byState = goodsMapper.findByState(goods);
        return byState;
    }

    @Override
    public boolean updateGoodState(Goods goods) {
        int i = goodsMapper.updateGoodState(goods);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean updateEndGoodState(Goods goods) {
        int i = goodsMapper.updateEndGoodState(goods);
        if (i>-1) return true;
        return false;
    }

    @Override
    public boolean updateGetGoodState(Goods goods) {
        int i = goodsMapper.updateGetGoodState(goods);
        if (i>-1) return true;
        return false;
    }
}
