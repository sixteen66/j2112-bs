package com.qf.j2112.controller;

import com.qf.j2112.anno.JwtAnno;
import com.qf.j2112.po.Company;
import com.qf.j2112.po.Order;
import com.qf.j2112.service.CompanyService;
import com.qf.j2112.service.OrderService;
import com.qf.j2112.vo.BaseResult;
import com.qf.j2112.vo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CompanyService companyService;

    @RequestMapping("/orderAll")
    public BaseResult findAll(){
        List<Order> all = orderService.findAll();
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(all);
        return baseResult;
    }
    @RequestMapping(value = "/orderOne",method = RequestMethod.POST)
    public BaseResult findOne(@RequestBody OrderInfo orderInfo){
        Company oneById = companyService.findOneById(orderInfo.getComname());

        List<Order> one = orderService.findOne(orderInfo);
        if (!ObjectUtils.isEmpty(oneById)) {
            for (Order o : one) {
                o.setComname(oneById.getComname());
            }
        }
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(one);
        return baseResult;
    }
    @JwtAnno(name = "新增订单")
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public BaseResult addOrder(@RequestBody Order order){
        order.setOrdertime(new Date());
        order.setOrderstate("未发货");
        Order order1 = orderService.addOrder(order);
        BaseResult baseResult=new BaseResult();

            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(order1);

        return baseResult;
    }
    @JwtAnno(name = "删除订单")
    @RequestMapping(value = "/delOrder",method = RequestMethod.POST)
    public BaseResult delOrder(@RequestBody Order order){
        boolean b = orderService.delOrder(order);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(order);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }
    @RequestMapping(value = "/orderById",method = RequestMethod.POST)
    public BaseResult findById(@RequestBody Order order){

        Order byState = orderService.findByID(order.getOrderid());
        BaseResult baseResult=new BaseResult();
        baseResult.setMsg("ok");
        baseResult.setCode(200);
        baseResult.setData(byState);
        return baseResult;
    }

    @RequestMapping(value = "orderState",method = RequestMethod.POST)
    public BaseResult updateOrderState(@RequestBody Order order){
        boolean b = orderService.updateOderState(order);
        BaseResult baseResult=new BaseResult();
        if (b){
            baseResult.setMsg("ok");
            baseResult.setCode(200);
            baseResult.setData(order);
        }
        else {
            baseResult.setMsg("ok");
            baseResult.setCode(-200);
            baseResult.setData(null);
        }
        return baseResult;
    }
}
