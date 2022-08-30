package com.lmf.elm.dao.impl;

import com.lmf.elm.dao.CartDao;
import com.lmf.elm.util.DBUtil;
import com.lmf.elm.vo.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {
    @Override
    public int saveCart(Connection conn, Cart cart) throws Exception {
        int result = 0;
        String sql = "INSERT INTO cart(foodId,businessId,userId,quantity) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cart.getFoodId());
            ps.setInt(2,cart.getBusinessId());
            ps.setString(3,cart.getUserId());
            ps.setInt(4,cart.getQuantity());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }

    @Override
    public int changeCart(Connection conn, Cart cart) throws Exception {
        int result = 0;
        String sql = "UPDATE cart SET quantity = ? WHERE foodId=? AND businessId = ? AND userId = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cart.getQuantity());
            ps.setInt(2,cart.getFoodId());
            ps.setInt(3,cart.getBusinessId());
            ps.setString(4,cart.getUserId());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }

    @Override
    public int removeCart(Connection conn, Cart cart) throws Exception {
        int result = 0;
        String sql = "DELETE FROM cart WHERE foodId=? AND businessId = ? AND userId = ?";
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,cart.getFoodId());
            ps.setInt(2,cart.getBusinessId());
            ps.setString(3,cart.getUserId());
            result = ps.executeUpdate();
        }finally {
            DBUtil.close(ps);
        }
        return result;
    }

    @Override
    public List<Cart> getCartsByBusinessIdAndUserId(Connection conn, int businessId, String userId) throws Exception {
        List<Cart> cartList = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE businessId = ? AND userId = ?";
        //String sql = "SELECT c.`cartId`,c.`foodId`,c.`businessId`,c.`userId`,c.`quantity`,b.`businessName`,b.`businessAddress`,b`businessExplain`,b.`businessImg`,b.`deliveryPrice`,b.`starPrice`,b.`orderTypeId`,b.`remarks` b_remarks,f.`foodName`,f.`foodExplain`,f.`foodImg`,f.`foodPrice`,f.`remarks` f_remarks FROM cart c LEFT JOIN business b ON c.`businessId` = b.`businessId` LEFT JOIN food f ON c.`foodId` = f.`foodId` WHERE c.businessId = ? AND c.userId = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1,businessId);
            ps.setString(2,userId);
            rs = ps.executeQuery();
            while(rs.next()){
                Cart cart = new Cart();
                cart.setCartId(rs.getInt("cartId"));
                cart.setFoodId(rs.getInt("foodId"));
                cart.setBusinessId(businessId);
                cart.setUserId(userId);
                cart.setQuantity(rs.getInt("quantity"));
                cartList.add(cart);
            }
        }finally {
            DBUtil.close(rs,ps);
        }
        return cartList;
    }

}
