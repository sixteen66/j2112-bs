package com.qf.j2112.service;

import com.qf.j2112.po.Order;
import com.qf.j2112.vo.OrderInfo;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    boolean delOrder(Order order);

    List<Order> findOne(OrderInfo info);

    Order addOrder(Order order);

    Order findByID(int id);

    boolean updateOderState(Order order);
}
