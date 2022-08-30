package com.lmf.elm.service;

import com.lmf.elm.po.OrdersMyPo;
import com.lmf.elm.po.OrdersPo;
import com.lmf.elm.vo.Orders;

import java.util.List;

public interface OrderService {
    int creatOrders(Orders orders);
    List<OrdersPo> findOrdersPo(Integer orderId);
    List<OrdersMyPo> findOrders(String userId);

    int changeOrder(int orderId);
}
