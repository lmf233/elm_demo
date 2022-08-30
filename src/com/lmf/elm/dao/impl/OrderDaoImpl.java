package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.OrderDao;
import com.lmf.elm.po.OrdersMyPo;
import com.lmf.elm.po.OrdersPo;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int saveOrder(Connection conn, Orders orders) throws Exception {
        String sql = "insert into orders values(null,?,?,?,?,?,0)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,orders.getUserId());
            ps.setInt(2,orders.getBusinessId());
            ps.setString(3,orders.getOrderDate());
            ps.setDouble(4,orders.getOrderTotal());
            ps.setInt(5,orders.getDaId());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }finally {
            DBUtil.close(rs,ps);
        }

    }

    @Override
    public List<OrdersPo> getOrdersById(Connection conn, Integer orderId) throws Exception {
        List<OrdersPo> ordersPoList = new ArrayList<>();
        String sql = "SELECT b.businessName,b.deliveryPrice,f.foodName,f.foodPrice,od.quantity,o.orderTotal\n" +
                "FROM orders o " +
                "LEFT JOIN business b " +
                "ON o.businessId = b.businessId " +
                "LEFT JOIN orderdetailet od " +
                "ON o.orderId = od.orderId " +
                "LEFT JOIN food f " +
                "ON od.foodId = f.foodId " +
                "WHERE o.orderId=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            rs = ps.executeQuery();
            while(rs.next()){
                OrdersPo ordersPo = new OrdersPo();
                ordersPo = new OrdersPo();
                ordersPo.setBusinessName(rs.getString("businessName"));
                ordersPo.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                ordersPo.setFoodName(rs.getString("foodName"));
                ordersPo.setFoodPrice(rs.getDouble("foodPrice"));
                ordersPo.setQuantity(rs.getInt("quantity"));
                ordersPo.setOrderTotal(rs.getDouble("orderTotal"));
                ordersPoList.add(ordersPo);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return ordersPoList;
    }

    @Override
    public List<OrdersMyPo> getOrdersByUserId(Connection conn, String userId) throws Exception {
        List<OrdersMyPo> ordersList = new ArrayList<>();
        String sql = "SELECT o.orderId,o.userId,b.businessName,o.orderDate,o.orderTotal,o.daId,o.orderState " +
                "FROM orders o,business b " +
                "WHERE o.businessId = b.businessId " +
                "AND o.userId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while(rs.next()){
                OrdersMyPo orders = new OrdersMyPo();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessName(rs.getString("businessName"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                ordersList.add(orders);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return ordersList;
    }

    @Override
    public int updateOrder(Connection conn, int orderId) throws Exception {
        int result = 0;
        String sql = "UPDATE orders SET orderState = 1 WHERE orderId = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderId);
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }
}
