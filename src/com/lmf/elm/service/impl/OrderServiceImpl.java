package com.lmf.elm.service.impl;

import com.lmf.elm.dao.CartDao;
import com.lmf.elm.dao.OrderDao;
import com.lmf.elm.dao.OrderDetailetDao;
import com.lmf.elm.dao.factory.CartDaoFactory;
import com.lmf.elm.dao.factory.OrderDaoFactory;
import com.lmf.elm.dao.factory.OrderDetailetDaoFactory;
import com.lmf.elm.dao.impl.OrderDaoImpl;
import com.lmf.elm.po.OrdersMyPo;
import com.lmf.elm.po.OrdersPo;
import com.lmf.elm.service.OrderService;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Cart;
import com.lmf.elm.vo.OrderDetailet;
import com.lmf.elm.vo.Orders;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    Connection conn = DBUtil.getConnection();
    @Override
    public int creatOrders(Orders orders) {
        int orderId = 0;
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        OrderDetailetDao orderDetailetDao = OrderDetailetDaoFactory.getOrderDetailetDao();
        CartDao cartDao = CartDaoFactory.getCartDao();
        try {
            DBUtil.beginTransaction();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            orders.setOrderDate(sdf.format(date));
            orderId = orderDao.saveOrder(this.conn,orders);
            List<Cart> cartList= cartDao.getCartsByBusinessIdAndUserId(this.conn,orders.getBusinessId(),orders.getUserId());
            for(Cart c:cartList){
                System.out.println(c);
                OrderDetailet detailet = new OrderDetailet();
                detailet.setOrderId(orderId);
                detailet.setFoodId(c.getFoodId());
                detailet.setQuantity(c.getQuantity());
                orderDetailetDao.saveDetailet(this.conn,detailet);
                cartDao.removeCart(this.conn,c);
            }

            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return orderId;
    }

    @Override
    public List<OrdersPo> findOrdersPo(Integer orderId) {
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        List<OrdersPo> ordersPoList = new ArrayList<>();
        try {
            DBUtil.beginTransaction();
            ordersPoList = orderDao.getOrdersById(this.conn,orderId);
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return ordersPoList;
    }

    @Override
    public List<OrdersMyPo> findOrders(String userId) {
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        List<OrdersMyPo> ordersList = new ArrayList<>();
        try {
            DBUtil.beginTransaction();
            ordersList = orderDao.getOrdersByUserId(this.conn,userId);
            for(OrdersMyPo o:ordersList){
                o.setOrdersPos(orderDao.getOrdersById(this.conn,o.getOrderId()));
            }
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return ordersList;
    }

    @Override
    public int changeOrder(int orderId) {
        int result = 0;
        OrderDao orderDao = OrderDaoFactory.getOrderDao();
        try {
            DBUtil.beginTransaction();
            result = orderDao.updateOrder(this.conn,orderId);
            DBUtil.commitTransaction();
        } catch (Exception e) {
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return result;
    }
}
