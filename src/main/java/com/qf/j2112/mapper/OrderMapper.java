package com.qf.j2112.mapper;

import com.qf.j2112.po.Order;
import com.qf.j2112.vo.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> findAll();

    int addOrder(Order order);

    int updateOrderState(Order order);

    int delOrder(Order order);

    List<Order> findOne(OrderInfo info);

    Order findByID(@Param("id") int orderid);
}
