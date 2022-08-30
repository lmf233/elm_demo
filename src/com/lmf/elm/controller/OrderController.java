package com.lmf.elm.controller;

import com.lmf.elm.po.OrdersMyPo;
import com.lmf.elm.po.OrdersPo;
import com.lmf.elm.service.OrderService;
import com.lmf.elm.service.impl.OrderServiceImpl;
import com.lmf.elm.vo.Orders;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OrderController {
    public int CreatOrders(HttpServletRequest req){
        String userId = req.getParameter("userId");
        int businessId = Integer.parseInt(req.getParameter("businessId"));
        int daId = Integer.parseInt(req.getParameter("daId"));
        Double orderTotal = Double.parseDouble(req.getParameter("orderTotal"));
        Orders orders = new Orders();
        orders.setUserId(userId);
        orders.setBusinessId(businessId);
        orders.setDaId(daId);
        orders.setOrderTotal(orderTotal);
        OrderService os = new OrderServiceImpl();
        int orderId = os.creatOrders(orders);
        return orderId;
    }
    public List<OrdersPo> findOrdersPoByOrderId(HttpServletRequest req){
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        OrderService os = new OrderServiceImpl();
        return os.findOrdersPo(orderId);
    }
    public List<OrdersMyPo> findOrdersByUserId(HttpServletRequest req){
        String userId = req.getParameter("userId");
        OrderService os = new OrderServiceImpl();
        return os.findOrders(userId);
    }
    public int payOrder(HttpServletRequest req){
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        OrderService os = new OrderServiceImpl();
        return os.changeOrder(orderId);
    }
}
