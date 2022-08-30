package com.lmf.elm.dao;

import com.lmf.elm.po.OrdersMyPo;
import com.lmf.elm.po.OrdersPo;
import com.lmf.elm.vo.Orders;

import java.sql.Connection;
import java.util.List;

public interface OrderDao {
    int saveOrder(Connection conn, Orders orders) throws Exception;
    List<OrdersPo> getOrdersById(Connection conn, Integer orderId)throws Exception;
    List<OrdersMyPo> getOrdersByUserId(Connection conn, String userId)throws Exception;

    int updateOrder(Connection conn, int orderId)throws Exception;
}
