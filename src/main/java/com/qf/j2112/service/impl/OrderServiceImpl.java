package com.qf.j2112.service.impl;

import com.qf.j2112.mapper.OrderMapper;
import com.qf.j2112.po.Order;
import com.qf.j2112.service.OrderService;
import com.qf.j2112.vo.OrderInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        List<Order> all = orderMapper.findAll();
        return all;
    }

    @Override
    public boolean delOrder(Order order) {
        int i = orderMapper.delOrder(order);
        if (i>-1){
            return true;
        }
        return false;
    }

    @Override
    public List<Order> findOne(OrderInfo info) {
        List<Order> orders = orderMapper.findOne(info);
        return orders;
    }

    @Override
    public Order addOrder(Order order) {
        int i = orderMapper.addOrder(order);
        if (i>-1) return order;
        return null;
    }

    @Override
    public Order findByID(int id) {
        Order byState = orderMapper.findByID(id);
        return byState;
    }

    @Override
    public boolean updateOderState(Order order) {
        int i = orderMapper.updateOrderState(order);
        if (i>-1) return true;
        return false;
    }
}
