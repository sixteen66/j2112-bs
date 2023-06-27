package com.qf.j2112.controller;

import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.Goods;
import com.qf.j2112.service.GoodsService;
import com.qf.j2112.vo.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public BaseResult addGoods(@RequestBody Goods goods){
        goods.setGoodsstate("未发货");

        int i = goodsService.addGoods(goods);
        BaseResult baseResult=new BaseResult();
        if (i>-1){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(goods);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }

    @RequestMapping(value = "/byState",method = RequestMethod.POST)
    public BaseResult findByState(@RequestBody Goods goods){

        List<Goods> byState = goodsService.findByState(goods);
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(byState);
        return baseResult;
    }
    @JwtAnno(name = "发货")
    @RequestMapping(value = "/goodState",method = RequestMethod.POST)
    public BaseResult updateGoodStaet(@RequestBody Goods goods){
        goods.setSendtime(new Date());
        boolean b = goodsService.updateGoodState(goods);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(goods);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }
    @JwtAnno(name = "收货")
    @RequestMapping(value = "/goodGetState",method = RequestMethod.POST)
    public BaseResult updateEndGoodStaet(@RequestBody Goods goods){
        goods.setGettime(new Date());
        boolean b = goodsService.updateEndGoodState(goods);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(goods);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }
    @JwtAnno(name = "送货")
    @RequestMapping(value = "/qsState",method = RequestMethod.POST)
    public BaseResult updateGetGoodState(@RequestBody Goods goods){
        boolean b = goodsService.updateGetGoodState(goods);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(goods);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }
}
